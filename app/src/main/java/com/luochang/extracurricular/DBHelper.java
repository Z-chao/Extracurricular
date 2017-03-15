package com.luochang.extracurricular;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.luochang.extracurricular.bean.ActivityBean;
import com.luochang.extracurricular.bean.UserBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by D on 2017/3/15.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {


    private static final String databaseName = "kewaihuodong.db";
    private static final int databaseVersion = 1;
    private static DBHelper instance;
    private Map<String, Dao> daos = new HashMap<String, Dao>();

    public DBHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserBean.class);
            TableUtils.createTable(connectionSource, ActivityBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }



    /**
     * 单例获取该Helper
     *
     * @param context
     * @return
     */
    public static synchronized DBHelper getHelper(Context context) {
        context = context.getApplicationContext();
        if (instance == null)
        {
            synchronized (DBHelper.class)
            {
                if (instance == null)
                    instance = new DBHelper(context);
            }
        }

        return instance;
    }


    /**
     *
     * @param clazz
     * @return
     * @throws SQLException
     */
    /*public synchronized Dao getDao(Class clazz) throws SQLException{
        Dao dao = null;
        String className = clazz.getSimpleName();

        if (daos.containsKey(className))
        {
            dao = daos.get(className);
        }
        if (dao == null)
        {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }*/

  /*  *//**
     * 释放资源
     *//*
    @Override
    public void close()
    {
        super.close();

        for (String key : daos.keySet())
        {
            Dao dao = daos.get(key);
            dao = null;
        }
    }*/




}
