package com.example.android.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.android.greendao.Setting;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SETTING".
*/
public class SettingDao extends AbstractDao<Setting, Long> {

    public static final String TABLENAME = "SETTING";

    /**
     * Properties of entity Setting.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Ip = new Property(2, String.class, "ip", false, "IP");
        public final static Property Mask = new Property(3, String.class, "mask", false, "MASK");
        public final static Property Dns = new Property(4, String.class, "dns", false, "DNS");
        public final static Property Gateway = new Property(5, String.class, "gateway", false, "GATEWAY");
        public final static Property ServerIp = new Property(6, String.class, "serverIp", false, "SERVER_IP");
        public final static Property ServerPort = new Property(7, Integer.class, "serverPort", false, "SERVER_PORT");
        public final static Property VideoIp = new Property(8, String.class, "videoIp", false, "VIDEO_IP");
        public final static Property VideoPort = new Property(9, Integer.class, "videoPort", false, "VIDEO_PORT");
        public final static Property SpareIp = new Property(10, String.class, "spareIp", false, "SPARE_IP");
        public final static Property SparePort = new Property(11, Integer.class, "sparePort", false, "SPARE_PORT");
        public final static Property Status = new Property(12, String.class, "status", false, "STATUS");
        public final static Property ModTime = new Property(13, java.util.Date.class, "modTime", false, "MOD_TIME");
        public final static Property Num = new Property(14, Integer.class, "num", false, "NUM");
        public final static Property Opened = new Property(15, String.class, "opened", false, "OPENED");
        public final static Property Oufk = new Property(16, String.class, "oufk", false, "OUFK");
        public final static Property Ouname = new Property(17, String.class, "ouname", false, "OUNAME");
        public final static Property Code = new Property(18, String.class, "code", false, "CODE");
        public final static Property ServerId = new Property(19, String.class, "serverId", false, "SERVER_ID");
        public final static Property Type = new Property(20, String.class, "type", false, "TYPE");
        public final static Property Usetype = new Property(21, String.class, "usetype", false, "USETYPE");
        public final static Property AlarmReportWaitTime = new Property(22, String.class, "alarmReportWaitTime", false, "ALARM_REPORT_WAIT_TIME");
        public final static Property AlarmStrategyMode = new Property(23, String.class, "alarmStrategyMode", false, "ALARM_STRATEGY_MODE");
        public final static Property RelatedMode = new Property(24, String.class, "relatedMode", false, "RELATED_MODE");
        public final static Property Js = new Property(25, String.class, "js", false, "JS");
        public final static Property Maxalarm = new Property(26, String.class, "maxalarm", false, "MAXALARM");
    }


    public SettingDao(DaoConfig config) {
        super(config);
    }
    
    public SettingDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SETTING\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"IP\" TEXT," + // 2: ip
                "\"MASK\" TEXT," + // 3: mask
                "\"DNS\" TEXT," + // 4: dns
                "\"GATEWAY\" TEXT," + // 5: gateway
                "\"SERVER_IP\" TEXT," + // 6: serverIp
                "\"SERVER_PORT\" INTEGER," + // 7: serverPort
                "\"VIDEO_IP\" TEXT," + // 8: videoIp
                "\"VIDEO_PORT\" INTEGER," + // 9: videoPort
                "\"SPARE_IP\" TEXT," + // 10: spareIp
                "\"SPARE_PORT\" INTEGER," + // 11: sparePort
                "\"STATUS\" TEXT," + // 12: status
                "\"MOD_TIME\" INTEGER," + // 13: modTime
                "\"NUM\" INTEGER," + // 14: num
                "\"OPENED\" TEXT," + // 15: opened
                "\"OUFK\" TEXT," + // 16: oufk
                "\"OUNAME\" TEXT," + // 17: ouname
                "\"CODE\" TEXT," + // 18: code
                "\"SERVER_ID\" TEXT," + // 19: serverId
                "\"TYPE\" TEXT," + // 20: type
                "\"USETYPE\" TEXT," + // 21: usetype
                "\"ALARM_REPORT_WAIT_TIME\" TEXT," + // 22: alarmReportWaitTime
                "\"ALARM_STRATEGY_MODE\" TEXT," + // 23: alarmStrategyMode
                "\"RELATED_MODE\" TEXT," + // 24: relatedMode
                "\"JS\" TEXT," + // 25: js
                "\"MAXALARM\" TEXT);"); // 26: maxalarm
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SETTING\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Setting entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(3, ip);
        }
 
        String mask = entity.getMask();
        if (mask != null) {
            stmt.bindString(4, mask);
        }
 
        String dns = entity.getDns();
        if (dns != null) {
            stmt.bindString(5, dns);
        }
 
        String gateway = entity.getGateway();
        if (gateway != null) {
            stmt.bindString(6, gateway);
        }
 
        String serverIp = entity.getServerIp();
        if (serverIp != null) {
            stmt.bindString(7, serverIp);
        }
 
        Integer serverPort = entity.getServerPort();
        if (serverPort != null) {
            stmt.bindLong(8, serverPort);
        }
 
        String videoIp = entity.getVideoIp();
        if (videoIp != null) {
            stmt.bindString(9, videoIp);
        }
 
        Integer videoPort = entity.getVideoPort();
        if (videoPort != null) {
            stmt.bindLong(10, videoPort);
        }
 
        String spareIp = entity.getSpareIp();
        if (spareIp != null) {
            stmt.bindString(11, spareIp);
        }
 
        Integer sparePort = entity.getSparePort();
        if (sparePort != null) {
            stmt.bindLong(12, sparePort);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(13, status);
        }
 
        java.util.Date modTime = entity.getModTime();
        if (modTime != null) {
            stmt.bindLong(14, modTime.getTime());
        }
 
        Integer num = entity.getNum();
        if (num != null) {
            stmt.bindLong(15, num);
        }
 
        String opened = entity.getOpened();
        if (opened != null) {
            stmt.bindString(16, opened);
        }
 
        String oufk = entity.getOufk();
        if (oufk != null) {
            stmt.bindString(17, oufk);
        }
 
        String ouname = entity.getOuname();
        if (ouname != null) {
            stmt.bindString(18, ouname);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(19, code);
        }
 
        String serverId = entity.getServerId();
        if (serverId != null) {
            stmt.bindString(20, serverId);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(21, type);
        }
 
        String usetype = entity.getUsetype();
        if (usetype != null) {
            stmt.bindString(22, usetype);
        }
 
        String alarmReportWaitTime = entity.getAlarmReportWaitTime();
        if (alarmReportWaitTime != null) {
            stmt.bindString(23, alarmReportWaitTime);
        }
 
        String alarmStrategyMode = entity.getAlarmStrategyMode();
        if (alarmStrategyMode != null) {
            stmt.bindString(24, alarmStrategyMode);
        }
 
        String relatedMode = entity.getRelatedMode();
        if (relatedMode != null) {
            stmt.bindString(25, relatedMode);
        }
 
        String js = entity.getJs();
        if (js != null) {
            stmt.bindString(26, js);
        }
 
        String maxalarm = entity.getMaxalarm();
        if (maxalarm != null) {
            stmt.bindString(27, maxalarm);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Setting entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String ip = entity.getIp();
        if (ip != null) {
            stmt.bindString(3, ip);
        }
 
        String mask = entity.getMask();
        if (mask != null) {
            stmt.bindString(4, mask);
        }
 
        String dns = entity.getDns();
        if (dns != null) {
            stmt.bindString(5, dns);
        }
 
        String gateway = entity.getGateway();
        if (gateway != null) {
            stmt.bindString(6, gateway);
        }
 
        String serverIp = entity.getServerIp();
        if (serverIp != null) {
            stmt.bindString(7, serverIp);
        }
 
        Integer serverPort = entity.getServerPort();
        if (serverPort != null) {
            stmt.bindLong(8, serverPort);
        }
 
        String videoIp = entity.getVideoIp();
        if (videoIp != null) {
            stmt.bindString(9, videoIp);
        }
 
        Integer videoPort = entity.getVideoPort();
        if (videoPort != null) {
            stmt.bindLong(10, videoPort);
        }
 
        String spareIp = entity.getSpareIp();
        if (spareIp != null) {
            stmt.bindString(11, spareIp);
        }
 
        Integer sparePort = entity.getSparePort();
        if (sparePort != null) {
            stmt.bindLong(12, sparePort);
        }
 
        String status = entity.getStatus();
        if (status != null) {
            stmt.bindString(13, status);
        }
 
        java.util.Date modTime = entity.getModTime();
        if (modTime != null) {
            stmt.bindLong(14, modTime.getTime());
        }
 
        Integer num = entity.getNum();
        if (num != null) {
            stmt.bindLong(15, num);
        }
 
        String opened = entity.getOpened();
        if (opened != null) {
            stmt.bindString(16, opened);
        }
 
        String oufk = entity.getOufk();
        if (oufk != null) {
            stmt.bindString(17, oufk);
        }
 
        String ouname = entity.getOuname();
        if (ouname != null) {
            stmt.bindString(18, ouname);
        }
 
        String code = entity.getCode();
        if (code != null) {
            stmt.bindString(19, code);
        }
 
        String serverId = entity.getServerId();
        if (serverId != null) {
            stmt.bindString(20, serverId);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(21, type);
        }
 
        String usetype = entity.getUsetype();
        if (usetype != null) {
            stmt.bindString(22, usetype);
        }
 
        String alarmReportWaitTime = entity.getAlarmReportWaitTime();
        if (alarmReportWaitTime != null) {
            stmt.bindString(23, alarmReportWaitTime);
        }
 
        String alarmStrategyMode = entity.getAlarmStrategyMode();
        if (alarmStrategyMode != null) {
            stmt.bindString(24, alarmStrategyMode);
        }
 
        String relatedMode = entity.getRelatedMode();
        if (relatedMode != null) {
            stmt.bindString(25, relatedMode);
        }
 
        String js = entity.getJs();
        if (js != null) {
            stmt.bindString(26, js);
        }
 
        String maxalarm = entity.getMaxalarm();
        if (maxalarm != null) {
            stmt.bindString(27, maxalarm);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Setting readEntity(Cursor cursor, int offset) {
        Setting entity = new Setting( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // ip
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // mask
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // dns
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // gateway
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // serverIp
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // serverPort
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // videoIp
            cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // videoPort
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // spareIp
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // sparePort
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // status
            cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)), // modTime
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // num
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // opened
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // oufk
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // ouname
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // code
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19), // serverId
            cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20), // type
            cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21), // usetype
            cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22), // alarmReportWaitTime
            cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23), // alarmStrategyMode
            cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24), // relatedMode
            cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25), // js
            cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26) // maxalarm
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Setting entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIp(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMask(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDns(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setGateway(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setServerIp(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setServerPort(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setVideoIp(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setVideoPort(cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9));
        entity.setSpareIp(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setSparePort(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setStatus(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setModTime(cursor.isNull(offset + 13) ? null : new java.util.Date(cursor.getLong(offset + 13)));
        entity.setNum(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setOpened(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setOufk(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setOuname(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setCode(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setServerId(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
        entity.setType(cursor.isNull(offset + 20) ? null : cursor.getString(offset + 20));
        entity.setUsetype(cursor.isNull(offset + 21) ? null : cursor.getString(offset + 21));
        entity.setAlarmReportWaitTime(cursor.isNull(offset + 22) ? null : cursor.getString(offset + 22));
        entity.setAlarmStrategyMode(cursor.isNull(offset + 23) ? null : cursor.getString(offset + 23));
        entity.setRelatedMode(cursor.isNull(offset + 24) ? null : cursor.getString(offset + 24));
        entity.setJs(cursor.isNull(offset + 25) ? null : cursor.getString(offset + 25));
        entity.setMaxalarm(cursor.isNull(offset + 26) ? null : cursor.getString(offset + 26));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Setting entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Setting entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Setting entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
