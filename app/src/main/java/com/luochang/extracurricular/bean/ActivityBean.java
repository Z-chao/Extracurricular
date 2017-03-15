package com.luochang.extracurricular.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by D on 2017/3/15.
 */


@DatabaseTable(tableName = "t_activity")
public class ActivityBean {

    @DatabaseField(id = true)
    private int _id;

    @DatabaseField(canBeNull = false)
    private String _activityName;


    @DatabaseField(canBeNull = false)
    private int _activityTime;

    @DatabaseField(canBeNull = false)
    private boolean _isfinish;




}
