package com.tt.app.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tableName";
    private static final String COLUMN_SITE_NAME = "SiteName";
    private static final String COLUMN_GID3 = "GID3";
    private static final String COLUMN_LAT = "LAT";
    private static final String COLUMN_LONG = "LONG";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_SITE_NAME + " TEXT, "
                + COLUMN_GID3 + " TEXT, "
                + COLUMN_LAT + " REAL, "
                + COLUMN_LONG + " REAL)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<Site> getAllSites() {
        List<Site> siteList = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor = null;

        try {
            db = this.getReadableDatabase();
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                // Obtenir les index des colonnes
                int siteNameIndex = cursor.getColumnIndex(COLUMN_SITE_NAME);
                int gid3Index = cursor.getColumnIndex(COLUMN_GID3);
                int latIndex = cursor.getColumnIndex(COLUMN_LAT);
                int lonIndex = cursor.getColumnIndex(COLUMN_LONG);

                // Vérifier que les index des colonnes sont valides
                if (siteNameIndex != -1 && gid3Index != -1 && latIndex != -1 && lonIndex != -1) {
                    do {
                        // Récupérer les valeurs des colonnes
                        String siteName = cursor.getString(siteNameIndex);
                        String gid3 = cursor.getString(gid3Index);
                        double lat = cursor.getDouble(latIndex);
                        double lon = cursor.getDouble(lonIndex);

                        // Créer un objet Site et l'ajouter à la liste
                        Site site = new Site(siteName, gid3, lat, lon);
                        siteList.add(site);
                    } while (cursor.moveToNext());
                } else {
                    // Loguer une erreur si les index ne sont pas valides
                    Log.e("DatabaseHelper", "Les noms de colonnes ne correspondent pas.");
                }
            }
        } catch (Exception e) {
            // Loguer l'exception si une erreur survient
            Log.e("DatabaseHelper", "Erreur lors de la récupération des sites.", e);
        } finally {
            // Fermer le Cursor et la base de données
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }

        return siteList;
    }

}
