package db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(
        name = CeibaDataBase.NAME,
        version = CeibaDataBase.VERSION,
        foreignKeyConstraintsEnforced = true)
public class CeibaDataBase {

    public static final String NAME = "CeibaDatabase";

    public static final int VERSION = 1;
}
