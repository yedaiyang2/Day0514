package com.example.administrator.day514;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.day514.gen.DUserDao;
import com.example.administrator.day514.gen.DaoMaster;
import com.example.administrator.day514.gen.DaoSession;
import com.example.administrator.day514.recycler.MyAdapter;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private EditText ed_age;
    private RecyclerView dao_rec;
    private DUserDao dUserDao;
    private String name;
    private String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        DaoUse();
    }

    public void initViews(){

        ed_name = findViewById(R.id.ed_name);
        ed_age = findViewById(R.id.ed_age);
        dao_rec = findViewById(R.id.dao_rec);
    }


    public void DaoUse(){

        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "User.db", null);

        SQLiteDatabase database = openHelper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(database);

        DaoSession daoSession = daoMaster.newSession();

        dUserDao = daoSession.getDUserDao();


    }

    public void daoselect(View view) {

        List<DUser> list = dUserDao.queryBuilder().list();
        dao_rec.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        MyAdapter myAdapter = new MyAdapter(list,this);
        dao_rec.setAdapter(myAdapter);
    }

    public void daoadd(View view) {

        name = ed_name.getText().toString();
        age = ed_age.getText().toString();
        dUserDao.insert(new DUser(null, name, age));
    }

    public void daoupdate(View view) {
        dUserDao.update(new DUser(null,name,age));
    }

    public void daodelete(View view) {

        dUserDao.deleteAll();
    }





}
