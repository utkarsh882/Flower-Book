package com.easternts.flowerworld.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.easternts.flowerworld.flowercategory.model.Category;
import com.easternts.flowerworld.flowersubcategory.model.FlowerViewModel;
import com.easternts.flowerworld.R;

import java.util.ArrayList;

/**
 * Created by Ranjit_Lepi on 06-Jun-16.
 */
public class Dalfile extends SQLiteOpenHelper {


    // Database
    private static final String DataBase_Name = "flowerDb";
    private static final int DATABASE_VERSION = 1;

    //Category
    private static final String TABLE_CATEGORY = "category";

    //category Table Column
    private static final String KEY_CATEGORY_ID = "category_id";
    private static final String KEY_CATEGORY_NAME = "category_name";
    private static final String KEY_CATEGORY_IMAGE = "category_image";

    //Flower Table
    public static final String TABLE_FLOWER = "flowerTable";
    private static final String KEY_FLOWER_ID = "flowerid";
    private static final String KEY_FLOWER_NAME = "flowername";
    private static final String KEY_FLOWER_DESCRIPATION = "flower_description";
    private static final String KEY_FLOWER_IMAGE = "flowerimage";
    private static final String KEY_FLOWER_FAVORITE = "flowerfavorite";
    private static final int FAVORITE_TRUE = 0;
    private static final int FAVORITE_FALSE = 1;

    private SQLiteDatabase db;

    public Dalfile(Context context) {
        super(context, DataBase_Name, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        createCategoryTable(db);
        InsertcategoryTable(db);
        createFlowerTable(db);
        insertFlowerTable(db);
    }


    //CategoryTable
    public void createCategoryTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CATEGORY + "("
                + KEY_CATEGORY_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT , "
                + KEY_CATEGORY_NAME + " INTEGER , "
                + KEY_CATEGORY_IMAGE + " INTEGER,"
                + KEY_FLOWER_FAVORITE + " INTEGER );");
        Log.e("CREATE Table Crete ", "CREATE table catreeeeeeeeeeeeeeeeee ");

    }


    // Insert category
    public void InsertcategoryTable(SQLiteDatabase db) {

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_CATEGORY_NAME).append(", ")
                .append(KEY_CATEGORY_IMAGE);

        // bulbous_plants 1
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.bulbous_plants).append(", ")
                .append(R.drawable.bulbous_plants)
                .append(" )").toString());
        Log.e("bulbous_plants", " Insert bulbous_plants sucessfully ");

        // cactisucculent_plants 2
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.cactisucculent_plants).append(", ")
                .append(R.drawable.cactisucculent_plants)
                .append(" )").toString());
        Log.e("cactisucculent_plants", " Insert cactisucculent_plants sucessfully ");

// flora_of_valley_of_flowers 3
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.flora_of_valley_of_flowers).append(", ")
                .append(R.drawable.flora_of_valley_of_flowers)
                .append(" )").toString());
        Log.e("floraofvalleyofflower", " Insert flora_of_valley_of_flowers sucessfully ");


// flowering_trees 4
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.flowering_trees).append(", ")
                .append(R.drawable.flowering_trees)
                .append(" )").toString());
        Log.e("flowering_trees", " Insert flowering_trees sucessfully ");

// flowers_of_fragrance 5
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.flowers_of_fragrance).append(", ")
                .append(R.drawable.flowers_of_fragrance)
                .append(" )").toString());
        Log.e("flowers_of_fragrance", " Insert flowers_of_fragrance sucessfully ");

// garden_flowers 6
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.garden_flowers).append(", ")
                .append(R.drawable.garden_flowers)
                .append(" )").toString());
        Log.e("garden_flowers", " Insert garden_flowers sucessfully ");

// grasses 7
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.grasses).append(", ")
                .append(R.drawable.grasses)
                .append(" )").toString());
        Log.e("grasses", " Insert grasses sucessfully ");

// himalayan_flowers 8
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.himalayan_flowers).append(", ")
                .append(R.drawable.himalayan_flowers)
                .append(" )").toString());
        Log.e("himalayan_flowers", " Insert himalayan_flowers sucessfully ");

// medicinal_plants 9
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.medicinal_plants).append(", ")
                .append(R.drawable.medicinal_plants)
                .append(" )").toString());
        Log.e("medicinal_plants", " Insert medicinal_plants sucessfully ");

// orchids 10
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.orchids).append(", ")
                .append(R.drawable.orchids)
                .append(" )").toString());
        Log.e("orchids", " Insert orchids sucessfully ");

// stroll_through_the_garden 11
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.stroll_through_the_garden).append(", ")
                .append(R.drawable.stroll_through_the_garden)
                .append(" )").toString());
        Log.e("stroll_throughthegarden", " Insert stroll_through_the_garden sucessfully ");

// vines_n_creepers 12
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.vines_n_creepers).append(", ")
                .append(R.drawable.vines_n_creepers)
                .append(" )").toString());
        Log.e("vines_n_creepers", " Insert vines_n_creepers sucessfully ");


// newly_added_flowers_first 14;
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_CATEGORY).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.newly_added_flowers_first).append(", ")
                .append(R.drawable.newly_added_flowers_first)
                .append(" )").toString());
        Log.e("newlyaddflowersfirst", " Insert newly_added_flowers_first sucessfully ");



    }

    //Flower Table
    public void createFlowerTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_FLOWER + "("
                + KEY_FLOWER_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT , "
                + KEY_FLOWER_NAME + " INTEGER , "
                + KEY_FLOWER_DESCRIPATION + " INTEGER ,"
                + KEY_FLOWER_IMAGE + " INTEGER ,"
                + KEY_FLOWER_FAVORITE + " INTEGER DEFAULT " + FAVORITE_FALSE + ","
                + KEY_CATEGORY_ID + " INTEGER );");
        Log.e("Table Crete ", " table catreeeeeeeeeeeeeeeeee ");
    }

    //Flower Table Insert Recoad
    private void insertFlowerTable(SQLiteDatabase db) {
        int bulbous_plants = 1;
        int cactisucculent_plants = 2;
        int flora_of_valley_of_flowers = 3;
        int flowering_trees = 4;
        int flowers_of_fragrance = 5;
        int garden_flowers = 6;
        int grasses = 7;
        int himalayan_flowers = 8;
        int medicinal_plants = 9;
        int orchids = 10;
        int stroll_through_the_garden = 11;
        int vines_n_creepers = 12;
        int newly_added_flowers_first = 13;
//        int browse_by_flower_color = 13;

        StringBuilder columnStringBuilder = new StringBuilder();
        columnStringBuilder.append(KEY_FLOWER_NAME).append(", ")
                .append(KEY_FLOWER_DESCRIPATION).append(", ")
                .append(KEY_FLOWER_IMAGE).append(", ")
                .append(KEY_CATEGORY_ID);
        // start Category bulbous_plants

//        bulbous_plants Category
        // chameleon_plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.chameleon_plant).append(", ")
                .append(R.string.chameleon_plant_description).append(", ")
                .append(R.drawable.chameleon_plant).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("chameleon_plant", " Insert chameleon_plant sucessfully ");

        // five_leaf_yam
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.five_leaf_yam).append(", ")
                .append(R.string.five_leaf_yam_description).append(", ")
                .append(R.drawable.five_leaf_yam).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("five_leaf_yam", " Insert sucessfully ");


        // green_taro
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.green_taro).append(", ")
                .append(R.string.green_taro_description).append(", ")
                .append(R.drawable.green_taro).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("green_taro", " Insert sucessfully ");


        // long_flowered_spider_lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.long_flowered_spider_lily).append(", ")
                .append(R.string.long_flowered_spider_lily_description).append(", ")
                .append(R.drawable.long_flowered_spider_lily).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("long_flowered_spider", " Insert sucessfully ");


        // long_leaf_pondweed
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.long_leaf_pondweed).append(", ")
                .append(R.string.long_leaf_pondweed_description).append(", ")
                .append(R.drawable.long_leaf_pondweed).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("long_leaf_pondweed", " Insert sucessfully ");

        // peace_lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.peace_lily).append(", ")
                .append(R.string.peace_lily_description).append(", ")
                .append(R.drawable.chameleon_plant).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("peace_lily", " Insert sucessfully ");


        // stepladder_ginger
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.stepladder_ginger).append(", ")
                .append(R.string.stepladder_ginger_description).append(", ")
                .append(R.drawable.stepladder_ginger).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("stepladder_ginger", " Insert sucessfully ");


        // wights_twisted_arum
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wights_twisted_arum).append(", ")
                .append(R.string.wights_twisted_arum_description).append(", ")
                .append(R.drawable.wights_twisted_arum).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("wights_twisted_arum", " Insert sucessfully ");

        // wild_daffodil
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wild_daffodil).append(", ")
                .append(R.string.wild_daffodil_description).append(", ")
                .append(R.drawable.wild_daffodil).append(", ")
                .append(bulbous_plants).append(" )").toString());
        Log.e("wild_daffodil", " Insert sucessfully ");

//        bulbous_plants END

//        CactiSucculent_plants category
        // Aloe vera
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.aloe_vera_plant).append(", ")
                .append(R.string.aloe_vera_plant_description).append(", ")
                .append(R.drawable.aloe_vera).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Aloevera", " Insert sucessfully ");

        // Brazilian vaseplant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.brazilian_vase_plant).append(", ")
                .append(R.string.brazilian_vase_plant_description).append(", ")
                .append(R.drawable.brazilian_vaseplant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Brazilian_vaseplant", " Insert sucessfully ");

        // Caribbean Century Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.caribbean_century_plant).append(", ")
                .append(R.string.caribbean_century_plant_description).append(", ")
                .append(R.drawable.caribbean_century_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Caribbean_Century_Plant", " Insert sucessfully ");

        // Century plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.century_plant).append(", ")
                .append(R.string.caribbean_century_plant_description).append(", ")
                .append(R.drawable.century_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Century_plant", " Insert sucessfully ");

        // Creeping Cradle Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.creeping_cradle_plant).append(", ")
                .append(R.string.creeping_cradle_plant_description).append(", ")
                .append(R.drawable.creeping_cradle_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Creeping_Cradle_Plant", " Insert sucessfully ");


        // Delta-shaped Aloe
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.delta_shaped_aloe_plant).append(", ")
                .append(R.string.delta_shaped_aloe_plant_description).append(", ")
                .append(R.drawable.delta_shaped_aloe).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Delta_shaped_Aloe", " Insert sucessfully ");

        // Foolproof Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.foolproof_plant).append(", ")
                .append(R.string.foolproof_plant_description).append(", ")
                .append(R.drawable.foolproof_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Foolproof_Plant", " Insert sucessfully ");

        // Gasteria
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.gasterias_plant).append(", ")
                .append(R.string.gasterias_plant_description).append(", ")
                .append(R.drawable.gasteria).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Gasteria", " Insert sucessfully ");

        // Hawaiian Ti Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.hawaiian_ti_plant).append(", ")
                .append(R.string.hawaiian_ti_plant_description).append(", ")
                .append(R.drawable.hawaiian_ti_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Hawaiian_Ti_Plant", " Insert sucessfully ");

        // Jade Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.jade_plant).append(", ")
                .append(R.string.jade_plant_description).append(", ")
                .append(R.drawable.jade_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Jade_Plant", " Insert sucessfully ");

        // Kenya Hyacinth
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.kenya_hyacinth_plant).append(", ")
                .append(R.string.kenya_hyacinth_plant_description).append(", ")
                .append(R.drawable.kenya_hyacinth).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Kenya_Hyacinth", " Insert sucessfully ");

        // Marsh Dewflower
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.marsh_dewflower_plant).append(", ")
                .append(R.string.marsh_dewflower_plant_description).append(", ")
                .append(R.drawable.marsh_dewflower).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Marsh_Dewflower", " Insert sucessfully ");

        // Silver Leaved Earth-Star
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.silver_leaved_earth_star_plant).append(", ")
                .append(R.string.silver_leaved_earth_star_plant_description).append(", ")
                .append(R.drawable.silver_leaved_earth_star).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Silver_Leaved_EarthStar", " Insert sucessfully ");

        // Silver Vase Bromeliad
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.silver_vase_bromeliad).append(", ")
                .append(R.string.silver_leaved_earth_star_plant_description).append(", ")
                .append(R.drawable.silver_vase_bromeliad).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("SilverVase_Bromeliad", " Insert sucessfully ");

        // Snake Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.snake_plant).append(", ")
                .append(R.string.snake_plant_description).append(", ")
                .append(R.drawable.snake_plant).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Aloevera", " Insert sucessfully ");

        // Soap Aloe
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.soap_aloe_plant).append(", ")
                .append(R.string.soap_aloe_plant_description).append(", ")
                .append(R.drawable.soap_aloe).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("SoapAloe", " Insert sucessfully ");

        // Spanish Dagger
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.spanish_dagger).append(", ")
                .append(R.string.spanish_dagger_plant_description).append(", ")
                .append(R.drawable.spanish_dagger).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Spanish_Dagger", " Insert sucessfully ");

        // Spider Aloe
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.spider_aloe).append(", ")
                .append(R.string.spider_aloe_plant_description).append(", ")
                .append(R.drawable.spider_aloe).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Spider_Aloe", " Insert sucessfully ");

        // Swan's neck agave
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.swans_neck_agave).append(", ")
                .append(R.string.swans_neck_agave_plant_description).append(", ")
                .append(R.drawable.swan_s_neck_agave).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Swans_neck_agave", " Insert sucessfully ");

        // Trifid Sedum
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.trifid_sedum).append(", ")
                .append(R.string.trifid_sedum_plant_description).append(", ")
                .append(R.drawable.trifid_sedum).append(", ")
                .append(cactisucculent_plants).append(" )").toString());
        Log.e("Trifid_Sedum", " Insert sucessfully ");

//        cactisucculent_plants END

//        Flora of Valley of Flowers CATEGORY


        // Beej Karela
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.beej_karela).append(", ")
                .append(R.string.beej_karela_plant_description).append(", ")
                .append(R.drawable.beej_karela).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Beej_Karela", " Insert sucessfully ");

        // Cheerful Senecio
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.cheerful_senecio).append(", ")
                .append(R.string.cheerful_senecio_plant_description).append(", ")
                .append(R.drawable.cheerful_senecio).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Cheerful_Senecio", " Insert sucessfully ");

        // Himalayan Indigo
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.himalayan_indigo).append(", ")
                .append(R.string.himalayan_indigo_plant_description).append(", ")
                .append(R.drawable.himalayan_indigo).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Himalayan_Indigo", " Insert sucessfully ");

        // Indian Oreorchis
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.indian_oreorchis).append(", ")
                .append(R.string.indian_oreorchis_plant_description).append(", ")
                .append(R.drawable.indian_oreorchis).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Indian_Oreorchis", " Insert sucessfully ");

        // Kumaon Iris
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.kumao_iris).append(", ")
                .append(R.string.kumao_iris_plant_description).append(", ")
                .append(R.drawable.kumaon_iris).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Kumaon_Iris", " Insert sucessfully ");

        // Kut
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.kut).append(", ")
                .append(R.string.kut_plant_description).append(", ")
                .append(R.drawable.kut).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Kut", " Insert sucessfully ");

        // Tall Alplily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.tall_alplily).append(", ")
                .append(R.string.tall_alplily_plant_description).append(", ")
                .append(R.drawable.tall_alplily).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Tall_Alplily", " Insert sucessfully ");

        // Wallich's Myriactis
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wallichs_myriactis).append(", ")
                .append(R.string.wallichs_myriactis_plant_description).append(", ")
                .append(R.drawable.wallich_s_myriactis).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Wallichs_Myriactis", " Insert sucessfully ");

        // Wight's Myriactis
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wights_myriactis).append(", ")
                .append(R.string.wights_myriactis_plant_description).append(", ")
                .append(R.drawable.wights_myriactis).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Wights_Myriactis", " Insert sucessfully ");

        // Yellow Coralroot
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.yellow_coralroot).append(", ")
                .append(R.string.yellow_coralroot_plant_description).append(", ")
                .append(R.drawable.yellow_coralroot).append(", ")
                .append(flora_of_valley_of_flowers).append(" )").toString());
        Log.e("Yellow_Coralroot", " Insert sucessfully ");

//        // Yellow Spotted White Saxifrage
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.yellow_Spotted_White_Saxifrage).append(", ")
//                .append(R.string.Yellow_Spotted_White_Saxifrage_description).append(", ")
//                .append(R.drawable.Yellow_Spotted_White_Saxifrage).append(", ")
//                .append(flora_of_valley_of_flowers).append(" )").toString());
//        Log.e("YellowWhiteSaxifrage", " Insert sucessfully ");

        //Flora of Valley of Flowers END

        //flowering_trees category

        // Bitter Nutmeg
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.bitter_nutmeg).append(", ")
                .append(R.string.bitter_nutmeg_description).append(", ")
                .append(R.drawable.bitter_nutmeg).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("bitter_nutmeg", " Insert sucessfully ");

        // Campbell's Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.campbells_magnolia).append(", ")
                .append(R.string.campbells_magnolia_description).append(", ")
                .append(R.drawable.campbell_s_magnolia).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("Campbells_Magnolia", " Insert sucessfully ");

        // Hard-Fruit Alphonsea
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.hard_fruit_alphonsea).append(", ")
                .append(R.string.hard_fruit_alphonsea_description).append(", ")
                .append(R.drawable.hard_fruit_alphonsea).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("HardFruit_Alphonsea", " Insert sucessfully ");

        // Malabar Nutmeg
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.malabar_nutmeg).append(", ")
                .append(R.string.malabar_nutmeg_description).append(", ")
                .append(R.drawable.malabar_nutmeg).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("Malabar_Nutmeg", " Insert sucessfully ");

        // Pond Apple
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.pond_apple).append(", ")
                .append(R.string.pond_apple_description).append(", ")
                .append(R.drawable.pond_apple).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("pond_apple", " Insert sucessfully ");

        // Tulip Tree
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.tulip_tree).append(", ")
                .append(R.string.tulip_tree_description).append(", ")
                .append(R.drawable.tulip_tree).append(", ")
                .append(flowering_trees).append(" )").toString());
        Log.e("Tulip_Tree", " Insert sucessfully ");

        //flowering_trees END

        //flowers_of_fragrance CATEGORY
        // Angelwing Jasmine
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.angelwing_jasmine).append(", ")
                .append(R.string.angelwing_jasmine_description).append(", ")
                .append(R.drawable.angelwing_jasmine).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("angelwing_jasmine", " Insert sucessfully ");

        // Bower Vine
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.bower_vine).append(", ")
                .append(R.string.bower_vine_description).append(", ")
                .append(R.drawable.bower_vine).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("bower_vine", " Insert sucessfully ");

        // Champa
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.champa).append(", ")
                .append(R.string.champa_description).append(", ")
                .append(R.drawable.champa).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("champa", " Insert sucessfully ");

        // Common White Frangipani
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.common_white_firangipani).append(", ")
                .append(R.string.common_white_firangipani_description).append(", ")
                .append(R.drawable.common_white_frangipani).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("common_white_frangipani", " Insert sucessfully ");

        // Dwarf Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.dwarf_magnolia).append(", ")
                .append(R.string.dwarf_magnolia_description).append(", ")
                .append(R.drawable.dwarf_magnolia).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("dwarf_magnolia", " Insert sucessfully ");

        // Hari Champa
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.hari_champa).append(", ")
                .append(R.string.hari_champa_description).append(", ")
                .append(R.drawable.hari_champa).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("hari_champa", " Insert sucessfully ");

        // Japanese Honeysuckle
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.japanese_honeysuckle).append(", ")
                .append(R.string.japanese_honeysuckle_description).append(", ")
                .append(R.drawable.japanese_honeysuckle).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("japanese_honeysuckle", " Insert sucessfully ");

        // Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.magnolia).append(", ")
                .append(R.string.magnolia_description).append(", ")
                .append(R.drawable.magnolia).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("magnolia", " Insert sucessfully ");

        // Potato Vine
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.potato_vines).append(", ")
                .append(R.string.potato_vines_description).append(", ")
                .append(R.drawable.potato_vine).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("potato_vine", " Insert sucessfully ");

        // Wax Flower
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wax_flower).append(", ")
                .append(R.string.wax_flower_description).append(", ")
                .append(R.drawable.wax_flower).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e(" wax_flower", " Insert sucessfully ");

        // Ylang Ylang
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ylang_ylang).append(", ")
                .append(R.string.ylang_ylang_description).append(", ")
                .append(R.drawable.ylang_ylang).append(", ")
                .append(flowers_of_fragrance).append(" )").toString());
        Log.e("ylang_ylang", " Insert sucessfully ");

        //flowers_of_fragrance END

        //garden_flowers category


        // Calico Flower
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.calico_flower).append(", ")
                .append(R.string.calico_flower_description).append(", ")
                .append(R.drawable.calico_flower).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Calico_Flower", " Insert sucessfully ");

        // Creeping Zinnia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.creeping_zinnia).append(", ")
                .append(R.string.creeping_zinnia_description).append(", ")
                .append(R.drawable.creeping_zinnia).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Creeping_Zinnia", " Insert sucessfully ");

        // Gloxinia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.gloxinia).append(", ")
                .append(R.string.gloxinia_description).append(", ")
                .append(R.drawable.gloxinia).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Gloxinia", " Insert sucessfully ");

        // Har Singar
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.har_singar).append(", ")
                .append(R.string.har_singar_description).append(", ")
                .append(R.drawable.har_singar).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Har_Singar", " Insert sucessfully ");

        // Large Yellow Foxglove
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.large_Yellow_foxglove).append(", ")
                .append(R.string.large_Yellow_foxglove_description).append(", ")
                .append(R.drawable.large_yellow_foxglove).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Large_Yellow_Foxglove", " Insert sucessfully ");

        // Lily Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.lily_magnolia).append(", ")
                .append(R.string.lily_magnolia_description).append(", ")
                .append(R.drawable.lily_magnolia).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Lily_Magnolia", " Insert sucessfully ");

        // Marigold yellow
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.marigold).append(", ")
                .append(R.string.marigold_description).append(", ")
                .append(R.drawable.marigold_yellow).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Marigold_yellow", " Insert sucessfully ");

        // Mexican Oleander
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.mexican_oleander).append(", ")
                .append(R.string.mexican_oleander_description).append(", ")
                .append(R.drawable.mexican_oleander).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Mexican_Oleander", " Insert sucessfully ");

        // Nilofar
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.nilofar).append(", ")
                .append(R.string.nilofar_description).append(", ")
                .append(R.drawable.nilofar).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Nilofar", " Insert sucessfully ");

        // Stinging Wigandia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.stinging_wigandia).append(", ")
                .append(R.string.stinging_wigandia_description).append(", ")
                .append(R.drawable.stinging_wigandia).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Stinging_Wigandia", " Insert sucessfully ");

        //Striped Philippine Violet
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.striped_philippine_violet).append(", ")
                .append(R.string.striped_philippine_violet_description).append(", ")
                .append(R.drawable.striped_philippine_violet).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("StripedPhilippineViolet", " Insert sucessfully ");

        // Sunset Bells
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.sunset_bells).append(", ")
                .append(R.string.sunset_bells_description).append(", ")
                .append(R.drawable.sunset_bells).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Sunset_Bells", " Insert sucessfully ");

        // White Water Lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.white_waterlily).append(", ")
                .append(R.string.white_waterlily_description).append(", ")
                .append(R.drawable.white_water_lily).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("White_Water_Lily", " Insert sucessfully ");

        // Yellow Pond Lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.yellow_pond_lily).append(", ")
                .append(R.string.yellow_pond_lily_description).append(", ")
                .append(R.drawable.yellow_pond_lily).append(", ")
                .append(garden_flowers).append(" )").toString());
        Log.e("Yellow_Pond_Lily", " Insert sucessfully ");

        //garden_flowers END

        //grasses category
        // Alpine Sedge
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.alpine_sedge).append(", ")
                .append(R.string.alpine_sedge_description).append(", ")
                .append(R.drawable.alpine_sedge).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("Alpine_Sedge", " Insert sucessfully ");

//        // Annual Blue-Eyed Grass
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.annual_blue_eyed_grass).append(", ")
//                .append(R.string.annual_blue_eyed_grass_description).append(", ")
//                .append(R.drawable.annual_blue_eyed_grass).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("annual_blue_eyed_grass", " Insert sucessfully ");

        // Balcooa Bamboo
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.balcooa_bamboo).append(", ")
                .append(R.string.balcooa_bamboo_description).append(", ")
                .append(R.drawable.balcooa_bamboo).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("balcooa_bamboo", " Insert sucessfully ");


        // Cheatgrass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.cheatgrass).append(", ")
                .append(R.string.cheatgrass_description).append(", ")
                .append(R.drawable.cheatgrass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("Cheatgrass", " Insert sucessfully ");

//        // Common Oat
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.common_oat).append(", ")
//                .append(R.string.common_oat_description).append(", ")
//                .append(R.drawable.common_oat).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("common_oat", " Insert sucessfully ");

        // Dwarf Reedgrass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.dwarf_reedgrass).append(", ")
                .append(R.string.dwarf_reedgrass_description).append(", ")
                .append(R.drawable.dwarf_reedgrass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("Dwarf_Reedgrass", " Insert sucessfully ");

        // Golden Bamboo
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.golden_bamboo).append(", ")
                .append(R.string.golden_bamboo_description).append(", ")
                .append(R.drawable.golden_bamboo).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("Golden_Bamboo", " Insert sucessfully ");

//        // Indian Thorny Bamboo
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.indian_thorny_bamboo).append(", ")
//                .append(R.string.indian_thorny_bamboo_description).append(", ")
//                .append(R.drawable.indian_thorny_bamboo).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("Indian_Thorny_Bamboo", " Insert sucessfully ");

        // Mangrove Grass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.mangrove_grass).append(", ")
                .append(R.string.mangrove_grass_description).append(", ")
                .append(R.drawable.mangrove_grass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("mangrove_grass", " Insert sucessfully ");

//        // Mauritian Grass
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.mauritian_grass).append(", ")
//                .append(R.string.mauritian_grass_description).append(", ")
//                .append(R.drawable.mauritian_grass).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("Mauritian_Grass", " Insert sucessfully ");

        // Nepal Foxtail Grass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.nepal_foxtail_grass).append(", ")
                .append(R.string.nepal_foxtail_grass_description).append(", ")
                .append(R.drawable.nepal_foxtail_grass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("nepal_foxtail_grass", " Insert sucessfully ");

        // Rescue Grass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.rescue_grass).append(", ")
                .append(R.string.rescue_grass_description).append(", ")
                .append(R.drawable.rescue_grass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("Rescue_Grass", " Insert sucessfully ");

        // Smooth Brome
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.smooth_brome).append(", ")
                .append(R.string.smooth_brome_description).append(", ")
                .append(R.drawable.smooth_brome).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("smooth_brome", " Insert sucessfully ");

        // Summer Grass
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.smooth_brome).append(", ")
                .append(R.string.smooth_brome_description).append(", ")
                .append(R.drawable.summer_grass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("summer_grass", " Insert sucessfully ");

//        // Swollen Finger Grass
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.swollen_finger_grass).append(", ")
//                .append(R.string.swollen_finger_grass_description).append(", ")
//                .append(R.drawable.swollen_finger_grass).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("swollen_finger_grass", " Insert sucessfully ");

        // Tausch's Goat-Grass,
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.tauschs_goat_grass).append(", ")
                .append(R.string.tauschs_goat_grass_description).append(", ")
                .append(R.drawable.tausch_s_goat_grass).append(", ")
                .append(grasses).append(" )").toString());
        Log.e("tausch_s_goat-grass", " Insert sucessfully ");

//        // Yellow Bluestem Grass
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.yellow_bluestem_grass).append(", ")
//                .append(R.string.yellow_bluestem_grass_description).append(", ")
//                .append(R.drawable.yellow_bluestem_grass).append(", ")
//                .append(grasses).append(" )").toString());
//        Log.e("yellow_bluestem_grass", " Insert sucessfully ");
//        //grasses END

        //himalayan_flowers category
        // Campbell's Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.campbells_magnolia).append(", ")
                .append(R.string.campbells_magnolia_description).append(", ")
                .append(R.drawable.campbell_s_magnolia).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("campbells_magnolia", " Insert sucessfully ");

        // Devil's Tongue
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.devils_tongue).append(", ")
                .append(R.string.devils_tongue_description).append(", ")
                .append(R.drawable.devil_s_tongue).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("devils_tongue", " Insert sucessfully ");

        // Egg Magnolia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.egg_magnolia).append(", ")
                .append(R.string.egg_magnolia_description).append(", ")
                .append(R.drawable.egg_magnolia).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("egg_magnolia", " Insert sucessfully ");

        // Fragrant Yellow Geranium
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.fragrant_yellow_geranium).append(", ")
                .append(R.string.fragrant_yellow_geranium_description).append(", ")
                .append(R.drawable.fragrant_yellow_geranium).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("FragrantYellowGeranium", " Insert sucessfully ");

        // Himalayan Melastome
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.himalayan_melastome).append(", ")
                .append(R.string.himalayan_melastome_description).append(", ")
                .append(R.drawable.himalayan_melastome).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("Himalayan_Melastome", " Insert sucessfully ");

        // Himalayan Peony
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.himalayan_peony).append(", ")
                .append(R.string.himalayan_peony_description).append(", ")
                .append(R.drawable.himalayan_peony).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("Himalayan_Peony", " Insert sucessfully ");

//        // Moorcroft's Saxifrage
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.Moorcrofts_Saxifrage).append(", ")
//                .append(R.string.Moorcrofts_Saxifrage_description).append(", ")
//                .append(R.drawable.Moorcrofts_Saxifrage).append(", ")
//                .append(himalayan_flowers).append(" )").toString());
//        Log.e("Moorcrofts_Saxifrage", " Insert sucessfully ");

//        // Small-Flowered Willow-Herb
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.small_flowered_willow_herb).append(", ")
//                .append(R.string.small_flowered_willow_herb_description).append(", ")
//                .append(R.drawable.small_flowered_willow_herb).append(", ")
//                .append(himalayan_flowers).append(" )").toString());
//        Log.e("SmallFloweredWillow", " Insert sucessfully ");

//        // Thread-Leaved Water-Crowfoot
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.thread_leaved_water_crowfoot).append(", ")
//                .append(R.string.thread_leaved_water_crowfoot_description).append(", ")
//                .append(R.drawable.thread_leaved_water_crowfoot).append(", ")
//                .append(himalayan_flowers).append(" )").toString());
//        Log.e("ThreadWaterCrowfoot", " Insert sucessfully ");

        // Tibetan Willow-Herb
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.tibetan_willow_herb).append(", ")
                .append(R.string.tibetan_willow_herb_description).append(", ")
                .append(R.drawable.tibetan_willow_herb).append(", ")
                .append(himalayan_flowers).append(" )").toString());
        Log.e("Tibetan_Willow_Herb", " Insert sucessfully ");

//        // Wallich Geranium
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.wallich_geranium).append(", ")
//                .append(R.string.wallich_geranium_description).append(", ")
//                .append(R.drawable.wallich_geranium).append(", ")
//                .append(himalayan_flowers).append(" )").toString());
//        Log.e("Wallich_Geranium", " Insert sucessfully ");

        //himalayan_flowers END

        //medicinal_plants category

        // Wintersweet
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.wintersweet).append(", ")
                .append(R.string.wintersweet_description).append(", ")
                .append(R.drawable.wintersweet).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Wintersweet", " Insert sucessfully ");

        // South-Indian Uvaria
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.south_indian_uvaria).append(", ")
                .append(R.string.south_Indian_uvaria_description).append(", ")
                .append(R.drawable.south_indian_uvaria).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("South_Indian_Uvaria", " Insert sucessfully ");

//        // Soursop
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.soursop).append(", ")
//                .append(R.string.soursop_description).append(", ")
//                .append(R.drawable.soursop).append(", ")
//                .append(medicinal_plants).append(" )").toString());
//        Log.e("Soursop", " Insert sucessfully ");

        // Rosy Orchid Ginger
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.rosy_orchid_ginger).append(", ")
                .append(R.string.rosy_orchid_ginger_description).append(", ")
                .append(R.drawable.rosy_orchid_ginger).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Rosy_Orchid_Ginger", " Insert sucessfully ");

        // Himalaya Onion
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.himalaya_onion).append(", ")
                .append(R.string.himalaya_onion_description).append(", ")
                .append(R.drawable.himalaya_onion).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Himalaya_Onion", " Insert sucessfully ");

        // Grass of the Dew
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.grass_of_the_dew).append(", ")
                .append(R.string.grass_of_the_dew_description).append(", ")
                .append(R.drawable.grass_of_the_dew).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Grass_of_the_Dew", " Insert sucessfully ");

        // Elephant Foot Yam
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.elephant_foot_yam).append(", ")
                .append(R.string.elephant_foot_yam_description).append(", ")
                .append(R.drawable.elephant_foot_yam).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Elephant_Foot_Yam", " Insert sucessfully ");

        //Chameleon Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.chameleon_plant).append(", ")
                .append(R.string.chameleon_plant_description).append(", ")
                .append(R.drawable.chameleon_plant).append(", ")
                .append(medicinal_plants).append(" )").toString());
        Log.e("Chameleon_Plant", " Insert sucessfully ");


        //medicinal_plants END

        //newly_added_flowers_first category

        //Dusky Fire-Brand Teak
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.dusky_fire_brand_teak).append(", ")
                .append(R.string.dusky_fire_brand_teak_description).append(", ")
                .append(R.drawable.dusky_fire_brand_teak).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("Dusky_Fire_Brand_Teak", " Insert sucessfully ");

        //Hairy-Root Luisia
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.hairy_root_luisia).append(", ")
                .append(R.string.hairy_root_luisia_description).append(", ")
                .append(R.drawable.hairy_root_luisia).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("Hairy_Root_Luisia", " Insert sucessfully ");

        //Hornbeam-Leaved Crossberry
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.hornbeam_leaved_crossberry).append(", ")
                .append(R.string.hornbeam_leaved_crossberry_description).append(", ")
                .append(R.drawable.hornbeam_leaved_crossberry).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("HornbeamLeavedCrossbery", " Insert sucessfully ");

        //Nilgiri Gastrochilus
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.nilgiri_gastrochilus).append(", ")
                .append(R.string.nilgiri_gastrochilus_description).append(", ")
                .append(R.drawable.nilgiri_gastrochilus).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("Nilgiri_Gastrochilus", " Insert sucessfully ");

        //Schimper's Sida
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.schimpers_sida).append(", ")
                .append(R.string.schimpers_sida_description).append(", ")
                .append(R.drawable.schimpers_sida).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("Schimpers_Sida", " Insert sucessfully ");

        //Spherical Rattlepod
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.spherical_rattlepod).append(", ")
                .append(R.string.spherical_rattlepod_description).append(", ")
                .append(R.drawable.spherical_rattlepod).append(", ")
                .append(newly_added_flowers_first).append(" )").toString());
        Log.e("Spherical_Rattlepod", " Insert sucessfully ");

//        //Strawberry Fields Gomphrena
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.strawberry_fields_gomphrena).append(", ")
//                .append(R.string.strawberry_fields_gomphrena_description).append(", ")
//                .append(R.drawable.strawberry_fields_gomphrena).append(", ")
//                .append(newly_added_flowers_first).append(" )").toString());
//        Log.e("StrawberyFieldGomphrena", " Insert sucessfully ");

        //newly_added_flowers_first END

        //orchids category

        //Acampe Orchid
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.acampe).append(", ")
                .append(R.string.acampe_description).append(", ")
                .append(R.drawable.acampe_orchid).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Acampe_Orchid", " Insert sucessfully ");

        //Ascocenda Krailerk Alba
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ascocenda_krailerk_alba).append(", ")
                .append(R.string.ascocenda_krailerk_alba_description).append(", ")
                .append(R.drawable.ascocenda_krailerk_alba).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Ascocenda_Krailerk_Alba", " Insert sucessfully ");

        //Bamboo Orchid
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.bamboo_orchid).append(", ")
                .append(R.string.bamboo_orchid_description).append(", ")
                .append(R.drawable.bamboo_orchid).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Bamboo_Orchid", " Insert sucessfully ");

        //Curled Aerides
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.curled_aerides).append(", ")
                .append(R.string.curled_aerides_description).append(", ")
                .append(R.drawable.curled_aerides).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Curled_Aerides", " Insert sucessfully ");

        //Fox Brush Orchid
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.fox_brush_orchid).append(", ")
                .append(R.string.fox_brush_orchid_description).append(", ")
                .append(R.drawable.fox_brush_orchid).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Fox_Brush_Orchid", " Insert sucessfully ");

        //Fringed Bulbophyllum
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.fringed_bulbophyllum).append(", ")
                .append(R.string.fringed_bulbophyllum_description).append(", ")
                .append(R.drawable.fringed_bulbophyllum).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Fringed_Bulbophyllum", " Insert sucessfully ");

        //Ochre-Yellow Acampe
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ochre_yellow_acampe).append(", ")
                .append(R.string.ochre_yellow_acampe_description).append(", ")
                .append(R.drawable.ochre_yellow_acampe).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Ochre_Yellow_Acampe", " Insert sucessfully ");

        //Small Warty Acampe
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.small_warty_acampe).append(", ")
                .append(R.string.small_warty_acampe_description).append(", ")
                .append(R.drawable.small_warty_acampe).append(", ")
                .append(orchids).append(" )").toString());
        Log.e("Small_Warty_Acampe", " Insert sucessfully ");

        //orchids END

        //stroll_through_the_garden category

        //Corn Cockle
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.corn_cockle).append(", ")
                .append(R.string.corn_cockle_description).append(", ")
                .append(R.drawable.corn_cockle).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Corn_Cockle", " Insert sucessfully ");

        //Grape-leaf Wood Rose
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.grape_leaf_wood_rose).append(", ")
                .append(R.string.grape_leaf_wood_rose_description).append(", ")
                .append(R.drawable.grape_leaf_wood_rose).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Grape_leaf_Wood_Rose", " Insert sucessfully ");

        //Nilofar
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.nilofar).append(", ")
                .append(R.string.nilofar_description).append(", ")
                .append(R.drawable.nilofar).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Nilofar", " Insert sucessfully ");

        //Peach Angel's Trumpet
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.peach_angels_trumpet).append(", ")
                .append(R.string.peach_angels_trumpet_description).append(", ")
                .append(R.drawable.peach_angel_s_trumpet).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Peach_Angels_Trumpet", " Insert sucessfully ");

//        //Prickly Waterlily
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.prickly_waterlily).append(", ")
//                .append(R.string.prickly_waterlily_description).append(", ")
//                .append(R.drawable.prickly_waterlily).append(", ")
//                .append(orchids).append(" )").toString());
//        Log.e("Prickly Waterlily", " Insert sucessfully ");

        //Purple Heart Glory
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.purple_heart_glory).append(", ")
                .append(R.string.purple_heart_glory_description).append(", ")
                .append(R.drawable.purple_heart_glory).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Purple_Heart_Glory", " Insert sucessfully ");

        //Railway Creeper
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.railway_creeper).append(", ")
                .append(R.string.railway_creeper_description).append(", ")
                .append(R.drawable.railway_creeper).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Railway_Creeper", " Insert sucessfully ");

        //Water Morning Glory
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.water_morning_glory).append(", ")
                .append(R.string.water_morning_glory_description).append(", ")
                .append(R.drawable.water_morning_glory).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Water_Morning_Glory", " Insert sucessfully ");

        //Yellow Pond Lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.yellow_pond_lily).append(", ")
                .append(R.string.yellow_pond_lily_description).append(", ")
                .append(R.drawable.yellow_pond_lily).append(", ")
                .append(stroll_through_the_garden).append(" )").toString());
        Log.e("Yellow_Pond_Lily", " Insert sucessfully ");

//        //Yellow Waterlily
//        db.execSQL(new StringBuilder().append("INSERT INTO ")
//                .append(TABLE_FLOWER).append(" (")
//                .append(columnStringBuilder).append(") VALUES ( ")
//                .append(R.string.yellow_waterlily).append(", ")
//                .append(R.string.yellow_waterlily_description).append(", ")
//                .append(R.drawable.yellow_waterlily).append(", ")
//                .append(stroll_through_the_garden).append(" )").toString());
//        Log.e("Yellow_Waterlily", " Insert sucessfully ");

        //stroll_through_the_garden END

        //vines_n_creepers category

        //Banana Passion Flower
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.banana_passion_flower).append(", ")
                .append(R.string.banana_passion_flower_description).append(", ")
                .append(R.drawable.banana_passion_flower).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Banana_Passion_Flower", " Insert sucessfully ");

        //Candy Corn Plant
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.candy_corn_plant).append(", ")
                .append(R.string.candy_corn_plant_description).append(", ")
                .append(R.drawable.candy_corn_plant).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Candy_Corn_Plant", " Insert sucessfully ");

        //Glory Lily
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.glory_lily).append(", ")
                .append(R.string.glory_lily_description).append(", ")
                .append(R.drawable.glory_lily).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Glory_Lily", " Insert sucessfully ");

        //Helmet Pepper
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.helmet_pepper).append(", ")
                .append(R.string.helmet_pepper_description).append(", ")
                .append(R.drawable.helmet_pepper).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Helmet_Pepper", " Insert sucessfully ");

        //Love in a Mist
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.love_in_a_mist).append(", ")
                .append(R.string.love_in_a_mist_description).append(", ")
                .append(R.drawable.love_in_a_mist).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Love_in_a_Mist", " Insert sucessfully ");

        //Maloo Creeper
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.maloo_creeper).append(", ")
                .append(R.string.maloo_creeper_description).append(", ")
                .append(R.drawable.maloo_creeper).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Maloo_Creeper", " Insert sucessfully ");

        //Puncture Vine
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.puncture_vine).append(", ")
                .append(R.string.puncture_vine_description).append(", ")
                .append(R.drawable.puncture_vine).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Puncture_Vine", " Insert sucessfully ");

        //Purple Passion Flower
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.purple_passion_flower).append(", ")
                .append(R.string.purple_passion_flower_description).append(", ")
                .append(R.drawable.purple_passion_flower).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Purple_Passion_Flower", " Insert sucessfully ");

        //Ragi
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.ragi).append(", ")
                .append(R.string.ragi_description).append(", ")
                .append(R.drawable.ragi).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Ragi", " Insert sucessfully ");

        //Spurred Butterfly Pea
        db.execSQL(new StringBuilder().append("INSERT INTO ")
                .append(TABLE_FLOWER).append(" (")
                .append(columnStringBuilder).append(") VALUES ( ")
                .append(R.string.spurred_butterfly_pea).append(", ")
                .append(R.string.spurred_butterfly_pea_description).append(", ")
                .append(R.drawable.spurred_butterfly_pea).append(", ")
                .append(vines_n_creepers).append(" )").toString());
        Log.e("Spurred_Butterfly_Pea", " Insert sucessfully ");

        //vines_n_creepers END
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDb() {
        db = getWritableDatabase();
    }

    public void closeDb() {
        db.close();
    }

    //display All Category
    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> categorys = new ArrayList<Category>();
        Cursor cursor = db.query(TABLE_CATEGORY, null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            categorys.add(new Category(cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_ID)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_IMAGE))));
        }
        cursor.close();
        return categorys;
    }


    //display All Flower
    public ArrayList<FlowerViewModel> getSubFlower(int r) {
        String whereCondition = KEY_CATEGORY_ID + " = " + r;
        ArrayList<FlowerViewModel> flowerViewModels = new ArrayList<FlowerViewModel>();
        Cursor cursor = db.query(TABLE_FLOWER, null, whereCondition, null, null, null, null, null);
        while (cursor.moveToNext()) {
            flowerViewModels.add(new FlowerViewModel(cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_ID)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_DESCRIPATION)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_IMAGE)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_ID))));
        }
        cursor.close();
        return flowerViewModels;
    }

    //display Favourite Flower
    public ArrayList<FlowerViewModel> getFavouriteFlowers() {
        String whereCondition = KEY_FLOWER_FAVORITE + " = " + FAVORITE_TRUE;
        ArrayList<FlowerViewModel> flowerViewModels = new ArrayList<FlowerViewModel>();
        Cursor cursor = db.query(TABLE_FLOWER, null, whereCondition, null, null, null, null, null);
        while (cursor.moveToNext()) {
            flowerViewModels.add(new FlowerViewModel(cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_ID)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_DESCRIPATION)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_IMAGE)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_ID))));
        }
        cursor.close();
        return flowerViewModels;
    }

    //Update Favourite Flower value
    public int updateFavouriteValue(int key_flower_id) {
        String whereCondition = KEY_FLOWER_ID + " = " + key_flower_id + " limit 1";
        Cursor cursor = db.query(TABLE_FLOWER, null, whereCondition, null, null, null, null);
//            int i = cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE));
//        db.update(TABLE_FLOWER,cv,"serial=" + serial,null);
        String whereCondition1 = KEY_FLOWER_ID + " = " + key_flower_id;
        while (cursor.moveToNext()) {
            int i = cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE));
            if (i == FAVORITE_FALSE) {
                ContentValues cv = new ContentValues();
                cv.put(KEY_FLOWER_FAVORITE, FAVORITE_TRUE);
                db.update(TABLE_FLOWER, cv, whereCondition1, null);
                return FAVORITE_TRUE;
            } else if (i == FAVORITE_TRUE) {
                ContentValues cv = new ContentValues();
                cv.put(KEY_FLOWER_FAVORITE, FAVORITE_FALSE);
                db.update(TABLE_FLOWER, cv, whereCondition1, null);
                return FAVORITE_FALSE;
            }
        }
        cursor.close();
        return 2;
    }

    //Update Favourite Flower value
    public int findFavouriteValue(int key_flower_id) {
        String whereCondition = KEY_FLOWER_ID + " = " + key_flower_id + " limit 1";
        int i=2;
        Cursor cursor = db.query(TABLE_FLOWER, new String[]{KEY_FLOWER_FAVORITE}, whereCondition, null, null, null, null);
        String whereCondition1 = KEY_FLOWER_ID + " = " + key_flower_id;
        while (cursor.moveToNext()) {
            i = cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE));
        }
        cursor.close();
        return i;
    }

    //display All Flower
    public FlowerViewModel getSubFlowers(int key_category_id) {
        String whereCondition = KEY_CATEGORY_ID + " = " + key_category_id;
        Cursor cursor = db.query(TABLE_FLOWER, null, whereCondition, null, null, null, null, null);
        while (cursor.moveToNext()) {
            return new FlowerViewModel(cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_ID)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_DESCRIPATION)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_IMAGE)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_ID)));
        }
        cursor.close();
        return null;
    }


    
public ArrayList<FlowerViewModel> getAtoZFlowers() {

    ArrayList<FlowerViewModel> flowerViewModels = new ArrayList<FlowerViewModel>();
    // Select All Query
    String orderBy = KEY_FLOWER_NAME ;

    Cursor cursor = db.query(true, TABLE_FLOWER, new String[]{
                    KEY_FLOWER_ID,
                    KEY_FLOWER_NAME,
                    KEY_FLOWER_DESCRIPATION,
                    KEY_FLOWER_IMAGE,
                    KEY_FLOWER_FAVORITE,
                    KEY_CATEGORY_ID,},
            null, null, KEY_FLOWER_NAME, null, orderBy, null);

    while (cursor.moveToNext()) {
        flowerViewModels.add(new FlowerViewModel(cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_ID)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_NAME)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_DESCRIPATION)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_IMAGE)), cursor.getInt(cursor.getColumnIndex(KEY_FLOWER_FAVORITE)), cursor.getInt(cursor.getColumnIndex(KEY_CATEGORY_ID))));
    }
    cursor.close();
    return flowerViewModels;
}

}
