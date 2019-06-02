import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;

import com.awad.naya.nayamusic.SongsList;

import java.util.ArrayList;

public class MySongsTable extends SQLiteOpenHelper
    {
        private static final int DATABASE_VERSION=1;//اسم الجيرسا
        private static final String DATABASE_NAME="CONTACTS_DB";//اسم قاعدة البيانات
        private static final String TABLE_SONGS="SONGS_TBL";//اسم الجدول
        //الصفات
        private static final String KEY_ID="_id";
        private static final String KEY_NAME="name";
        private static final String KEY_SINGER="singer";
        private static final String KEY_DATE="date";
        private static final String KEY_WATCHERS="watchers";
        //الصفات

        public MySongsTable(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }//تصحيح الدالة البنائية(تتلقى ال context فقط بدل كل الصفات)

        @Override
        public void onCreate(SQLiteDatabase db)//// عن طريق الكائن db نستيطيع الاتصال بقاعدة البيانات
        {
        //دالة تبني الجدول وتعمل مرة واحدة فقط
            String CREATE_SONGS_TABLE="CREATE TABLE"+ TABLE_SONGS+"("+KEY_ID+"INTEGER PRIMARY KEY,"+KEY_NAME+"TEXT,"+KEY_SINGER+"TEXT,"+KEY_DATE+"TEXT,"+KEY_WATCHERS+"TEXT"+"(";
            String sqlCreate=null;
            db.execSQL(sqlCreate);//من أجل تشغيل الأوامر في قاعدة البيانات نحتاج الى دالة execSQL
            //كود لبناء الجدول
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)//دالة تحدث بالجدول (زيادة-تنقيص-تغيير)
        {
            String sqlDrop="DROP TABLE IF EXISTS "+TABLE_SONGS;
            db.execSQL(sqlDrop);
            onCreate(db);

        }
        public long addSong(Songs1 song)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(KEY_NAME,song.getName());
            values.put(KEY_SINGER,song.getSinger());
            values.put(KEY_DATE,song.getDate());
            values.put(KEY_WATCHERS,song.getWatchers());
            long row=db.insert(TABLE_SONGS,null,values);
            db.close();
            return row;
        }
        public int updateSong(Songs1 song)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put(KEY_NAME,song.getName());
            values.put(KEY_SINGER,song.getSinger());
            values.put(KEY_DATE,song.getDate());
            values.put(KEY_WATCHERS,song.getWatchers());
            int num=db.update(TABLE_SONGS,values,KEY_ID+"="+song.get_id(),null);
            db.close();
            return num;
        }
        public int deleteSongByld(Songs1 song)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            int num=db.delete(TABLE_SONGS,KEY_ID+"="+song.get_id(),null);
            db.close();
             return  num;
        }
        public ArrayList<Songs1> getSongsList()
        {
            ArrayList<Songs1> allSongs= new ArrayList<>();
            String selectQuery="SELECT*FROM "+TABLE_SONGS;
            SQLiteDatabase db =this.getWritableDatabase();
            Cursor cursor=db.rawQuery(selectQuery,null);
            boolean flag=cursor.moveToFirst();
            while (flag==true) {
                {
                    Songs1 song = new Songs1();
                    song.set_id(cursor.getLong(0));//id
                    song.setName(cursor.getString(1));//name
                    song.setSinger(cursor.getString(2));//singer
                    song.setDate(cursor.getString(3));//date
                    song.setWatchers(cursor.getInt(4));//watchers
                    allSongs.add(song);
                    flag=cursor.moveToNext();
                }
                while (cursor.moveToNext());
            }
            return allSongs;
        }

    }

