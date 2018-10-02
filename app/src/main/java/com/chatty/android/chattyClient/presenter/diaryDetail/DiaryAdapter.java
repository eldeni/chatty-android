package com.chatty.android.chattyClient.presenter.diaryDetail;

import android.content.Context;
import android.icu.text.DateFormat;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chatty.android.chattyClient.R;
import com.chatty.android.chattyClient.model.Diary;
import com.chatty.android.chattyClient.model.State;

import java.util.ArrayList;
import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryHolder> {
  private Context context;
  private ArrayList<Diary> data;

  public DiaryAdapter(Context applicationContext, ArrayList<Diary> diaries) {
    this.context = applicationContext;
    this.data = diaries;
  }

  public void update(List<Diary> data) {
    this.data.clear();
    this.data.addAll(data);
    this.notifyDataSetChanged();
  }

  @NonNull
  @Override
  public DiaryHolder onCreateViewHolder(
    @NonNull ViewGroup parent,
    int viewType
  ) {
    View view  = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_diary, parent, false);

    return new DiaryHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull DiaryHolder holder, int position) {
    Diary diary = this.data.get(position);

    holder.question.setText(diary.getQuestion());
    holder.answer.setText(diary.getAnswer());
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class DiaryHolder extends RecyclerView.ViewHolder {
    TextView question;
    TextView answer;

    public DiaryHolder(@NonNull View itemView) {
      super(itemView);
      question = itemView.findViewById(R.id.textView_question);
      answer = itemView.findViewById(R.id.textView_answer);
    }
  }
}
