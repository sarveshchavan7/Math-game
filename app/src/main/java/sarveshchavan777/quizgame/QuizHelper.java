package sarveshchavan777.quizgame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class QuizHelper extends SQLiteOpenHelper {
    Context context;
    private static final int DATABASE_VERSION = 13;

    private static final String DATABASE_NAME = "mathsone";
    private static final String TABLE_QUEST = "quest";
    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
    private static final String KEY_OPTC = "optc";

    private SQLiteDatabase dbase;

    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestion();
        // db.close();
    }

    private void addQuestion() {
        Question q1 = new Question("4+3 = ?", "7", "8", "6", "7");
        this.addQuestion(q1);
        Question q2 = new Question("1+19 = ?", "18", "19", "20", "20");
        this.addQuestion(q2);
        Question q3 = new Question("11-4 = ?", "6", "7", "8", "7");
        this.addQuestion(q3);
        Question q4 = new Question("4+8 = ?", "12", "13", "14", "12");
        this.addQuestion(q4);
        Question q5 = new Question("4-2 = ?", "1", "3", "2", "2");
        this.addQuestion(q5);
        Question q6 = new Question("0+1 = ?", "1", "0", "10", "1");
        this.addQuestion(q6);
        Question q7 = new Question("10-10 = ?", "0", "9", "1", "0");
        this.addQuestion(q7);
        Question q8 = new Question("4+5 = ?", "8", "7", "9", "9");
        this.addQuestion(q8);
        Question q9 = new Question("2+4 = ?", "6", "7", "5", "6");
        this.addQuestion(q9);
        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
        this.addQuestion(q10);
        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
        this.addQuestion(q11);
        Question q12 = new Question("2+6 = ?", "8", "7", "5", "8");
        this.addQuestion(q12);
        Question q13 = new Question("1+5 = ?", "7", "6", "5", "6");
        this.addQuestion(q13);
        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
        this.addQuestion(q14);
        Question q15 = new Question("13+1 = ?", "14", "15", "16", "14");
        this.addQuestion(q15);
        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
        this.addQuestion(q16);
        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
        this.addQuestion(q17);
        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
        this.addQuestion(q18);
        Question q19 = new Question("3+3 = ?", "6", "7", "5", "6");
        this.addQuestion(q19);
        Question q20 = new Question("4+2 = ?", "6", "7", "5", "6");
        this.addQuestion(q20);
        Question q21 = new Question("6-5 = ?", "5", "4", "1", "1");
        this.addQuestion(q21);
        // END
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);

        onCreate(db);
    }


    public void addQuestion(Question quest) {


        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());


        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Question quest = new Question();
            quest.setID(cursor.getInt(0));
            quest.setQUESTION(cursor.getString(1));
            quest.setANSWER(cursor.getString(2));
            quest.setOPTA(cursor.getString(3));
            quest.setOPTB(cursor.getString(4));
            quest.setOPTC(cursor.getString(5));

            quesList.add(quest);
        }

        return quesList;
    }


}
