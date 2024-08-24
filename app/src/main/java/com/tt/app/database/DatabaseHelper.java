package com.tt.app.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "your_database.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créer la table si elle n'existe pas
        db.execSQL("CREATE TABLE IF NOT EXISTS tableName (SiteName TEXT, GID3 TEXT, LAT REAL, LONG REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Gérer la mise à jour de la base de données
        db.execSQL("DROP TABLE IF EXISTS tableName");
        onCreate(db);
    }

    public List<Site> getAllSites() {
        List<Site> siteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tableName", null);

        if (cursor != null && cursor.moveToFirst()) {
            int siteNameIndex = cursor.getColumnIndex("SiteName");
            int gid3Index = cursor.getColumnIndex("GID3");
            int latIndex = cursor.getColumnIndex("LAT");
            int lonIndex = cursor.getColumnIndex("LONG");

            do {
                // Check for valid column indexes
                if (siteNameIndex >= 0 && gid3Index >= 0 && latIndex >= 0 && lonIndex >= 0) {
                    String siteName = cursor.getString(siteNameIndex);
                    String gid3 = cursor.getString(gid3Index);
                    double lat = cursor.getDouble(latIndex);
                    double lon = cursor.getDouble(lonIndex);

                    Site site = new Site(siteName, gid3, lat, lon);
                    siteList.add(site);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        db.close();
        return siteList;
    }


    public List<Site> rechercherSiteParNom(String nom) {
        List<Site> siteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"SiteName", "GID3", "LAT", "LONG"};
        String selection = "SiteName LIKE ?";
        String[] selectionArgs = {"%" + nom + "%"};

        Cursor cursor = db.query("tableName", columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            int siteNameIndex = cursor.getColumnIndex("SiteName");
            int latIndex = cursor.getColumnIndex("LAT");
            int lonIndex = cursor.getColumnIndex("LONG");

            do {
                // Check for valid column indexes
                if (siteNameIndex >= 0 && latIndex >= 0 && lonIndex >= 0) {
                    Site site = new Site();
                    site.setSiteName(cursor.getString(siteNameIndex));
                    site.setLatitude(cursor.getDouble(latIndex));
                    site.setLongitude(cursor.getDouble(lonIndex));
                    siteList.add(site);
                }
            } while (cursor.moveToNext());

            cursor.close();
        }
        db.close();
        return siteList;
    }



}
