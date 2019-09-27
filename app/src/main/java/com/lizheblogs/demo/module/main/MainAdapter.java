package com.lizheblogs.demo.module.main;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lizheblogs.demo.R;
import com.lizheblogs.demo.bean.MainBean;
import com.lizheblogs.demo.common.listener.DemoCallback;
import com.lizheblogs.demo.databinding.ItemMainBinding;

import java.util.List;

/**
 * Created by LiZhe on 2019-09-27.
 * com.lizheblogs.demo
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainBean> list;
    private DemoCallback<MainBean> callback;

    public MainAdapter(DemoCallback<MainBean> callback) {
        this.callback = callback;
        setHasStableIds(false);
    }

    public void setList(final List<MainBean> beans) {
        if (list == null) {
            list = beans;
            notifyItemRangeInserted(0, beans.size());
        } else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return list.size();
                }

                @Override
                public int getNewListSize() {
                    return beans.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    MainBean old = list.get(oldItemPosition);
                    MainBean newItem = beans.get(newItemPosition);
                    return old.getName() == newItem.getName();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return areItemsTheSame(oldItemPosition, newItemPosition);
                }
            });
            list = beans;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMainBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_main,
                        parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.setListener(callback);
        holder.binding.setItem(list.get(position));
        holder.binding.executePendingBindings();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final ItemMainBinding binding;

        ViewHolder(ItemMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}