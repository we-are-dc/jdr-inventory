package com.jdrinventory.inventory_jdr.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jdrinventory.inventory_jdr.model.dao.CharacterDAO;
import com.jdrinventory.inventory_jdr.model.dao.CharacterWithToolsDAO;
import com.jdrinventory.inventory_jdr.model.dao.ToolDAO;
import com.jdrinventory.inventory_jdr.model.data.Character;
import com.jdrinventory.inventory_jdr.model.data.Tool;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Character.class, Tool.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "inventory-database")
            .addCallback(
                new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NotNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        databaseWriteExecutor.execute(() -> {});
                    }
                }
            )
            .build();
    }

    public abstract CharacterDAO characterDao();

    public abstract CharacterWithToolsDAO characterWithToolsDao();

    public abstract ToolDAO toolDao();

    private static volatile AppDatabase INSTANCE;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = INSTANCE.buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }
}
