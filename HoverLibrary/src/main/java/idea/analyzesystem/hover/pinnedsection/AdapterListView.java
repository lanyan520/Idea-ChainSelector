package idea.analyzesystem.hover.pinnedsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public abstract class AdapterListView<T extends BasePinnedSectionBean> extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {
	protected OnPinnedSectionListener<T> onPinnedSectionListener;
	protected ArrayList<T> list;
	private Context context;
	public ArrayList<T> getList() {
		return list;
	}
	public void setList(ArrayList<T> list) {
		if(list!=null){
			this.list = list;
		}else{
			list=new ArrayList<>();
		}
	}
	public AdapterListView(Context context,ArrayList<T> list,OnPinnedSectionListener<T> onPinnedSectionListener){
		this.setList(list);
		this.context=context;
		this.onPinnedSectionListener = onPinnedSectionListener;
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public T getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View converView, ViewGroup viewGrop) {

		ViewHolder viewHolder = null ;
		if (converView == null)
		{
			View itemView = LayoutInflater.from(context).inflate(setLayoutRes(), viewGrop,false);
			viewHolder = new ViewHolder(context, itemView, viewGrop, position);
			viewHolder.mLayoutId = setLayoutRes();
		} else {
			viewHolder = (ViewHolder) converView.getTag();
			viewHolder.mPosition = position;
		}
		T itemBean = getItem(position);
		if (itemBean.getType()== T.SECTION) {
			convertSection(viewHolder, getItem(position), position);
		}else{
			convertItem(viewHolder, getItem(position), position);
		}
		return viewHolder.getConvertView();
	}

	protected abstract void convertSection(ViewHolder viewHolder, T item, int position);

	protected abstract void convertItem(ViewHolder viewHolder, T item, int position);

	protected abstract int setLayoutRes();

	@Override
	public boolean isItemViewTypePinned(int viewType) {
		return viewType == T.SECTION;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}
	@Override
	public int getItemViewType(int position) {
		return ((T)getItem(position)).getType();
	}
}
