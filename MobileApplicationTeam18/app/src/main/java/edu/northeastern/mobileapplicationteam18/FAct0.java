//package edu.northeastern.mobileapplicationteam18;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import android.util.Log;
//import android.view.View;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;
//
//
//public class FAct0 extends AppCompatActivity implements FAdapter.OnItemClickListener{
//
//    private RecyclerView mRecyclerView;
//    private FAdapter mAdapter;
//    private ProgressBar mProgressBar;
//    private FirebaseStorage mStorage;
//    private DatabaseReference mDatabaseRef;
//    private ValueEventListener mDBListener;
////    private List<FActivity> mTeachers;
//    private List<FActivity> factivity;
//
////    private void openDetailActivity(String[] data){
////        Intent intent = new Intent(this, DetailsActivity.class);
////        intent.putExtra("NAME_KEY",data[0]);
////        intent.putExtra("DESCRIPTION_KEY",data[1]);
////        intent.putExtra("IMAGE_KEY",data[2]);
////        startActivity(intent);
////    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate ( savedInstanceState );
//        setContentView ( R.layout.activity_fimage);
//
//        mRecyclerView = findViewById(R.id.mRecyclerView);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager (this));
//
//        mProgressBar = findViewById(R.id.myDataLoaderProgressBar);
//        mProgressBar.setVisibility(View.VISIBLE);
//
//        factivity = new ArrayList<> ();
//        mAdapter = new FAdapter (FAct0.this, factivity);
//        mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(FAct0.this);
//
//        mStorage = FirebaseStorage.getInstance();
//        mDatabaseRef = FirebaseDatabase.getInstance().getReference("teachers_uploads");
//
//        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                factivity.clear();
//                System.out.println("-------------------snapshot----------------");
//                System.out.println(dataSnapshot.getChildren());
//                System.out.println("endendend");
//
//                for (DataSnapshot teacherSnapshot : dataSnapshot.getChildren()) {
//                    FActivity upload = teacherSnapshot.getValue(FActivity.class);
//                    upload.setKey(teacherSnapshot.getKey());
//                    factivity.add(upload);
//                    Log.e("aaaaaa", "aaaaaaa");
//                }
//                mAdapter.notifyDataSetChanged();
//                mProgressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(FAct0.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                mProgressBar.setVisibility(View.INVISIBLE);
//            }
//        });
//
//    }
//    public void onItemClick(int position) {
//        FActivity clickedTeacher=factivity.get(position);
//        String[] teacherData={clickedTeacher.getName(),clickedTeacher.getDescription(),clickedTeacher.getImageUrl()};
////        openDetailActivity(teacherData);
//    }
//
//    @Override
//    public void onShowItemClick(int position) {
//        FActivity clickedTeacher=factivity.get(position);
//        String[] teacherData={clickedTeacher.getName(),clickedTeacher.getDescription(),clickedTeacher.getImageUrl()};
////        openDetailActivity(teacherData);
//    }
//
//    @Override
//    public void onDeleteItemClick(int position) {
//        FActivity selectedItem = factivity.get(position);
//        final String selectedKey = selectedItem.getKey();
//
//        StorageReference imageRef = mStorage.getReferenceFromUrl(selectedItem.getImageUrl());
//        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void> () {
//            @Override
//            public void onSuccess(Void aVoid) {
//                mDatabaseRef.child(selectedKey).removeValue();
//                Toast.makeText(FAct0.this, "Item deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//    protected void onDestroy() {
//        super.onDestroy();
//        mDatabaseRef.removeEventListener(mDBListener);
//    }
//
//}
