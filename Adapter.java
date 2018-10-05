package alarm_clock.com.alarm_clock;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    private MainActivity activity;
    List<GetDataList> getDataAdapter;

    public Adapter(MainActivity activity, List<GetDataList> getDataAdapter){

        super();

        this.activity = activity;
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.recycler_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {

        GetDataList getDataAdapter1 =  getDataAdapter.get(position);

        holder.Datetxt.setText(getDataAdapter1.getDate());

        holder.Timetxt.setText(String.valueOf(getDataAdapter1.getTime()));

        holder.Titletxt.setText(getDataAdapter1.getTitle());

       // holder.SubjectTextView.setText(getDataAdapter1.getSubject());

    }

    @Override
    public int getItemCount() {

        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView Datetxt;
        public TextView Timetxt;
        public TextView Titletxt;
       // public TextView SubjectTextView;


        public ViewHolder(View itemView) {

            super(itemView);

            Datetxt = (TextView) itemView.findViewById(R.id.Datetxt) ;
            Timetxt = (TextView) itemView.findViewById(R.id.Timetxt) ;
            Titletxt = (TextView) itemView.findViewById(R.id.Titletxt) ;
           // SubjectTextView = (TextView) itemView.findViewById(R.id.textView8) ;


        }
    }
}