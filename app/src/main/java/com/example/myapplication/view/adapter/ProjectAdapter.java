//package com.example.myapplication.view.adapter;
//
//import android.view.LayoutInflater;
//import android.view.ViewGroup;
//
//import androidx.annotation.Nullable;
//import androidx.databinding.DataBindingUtil;
//import androidx.recyclerview.widget.DiffUtil;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.example.myapplication.R;
//
//import java.util.List;
//import java.util.Objects;
//
//public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {
//
//    List<?> list;
//
//    @Nullable
//    private final ClickCallback clickCallback;
//
//    public ProjectAdapter(@Nullable ClickCallback projectClickCallback) {
//        this.clickCallback = projectClickCallback;
//    }
//
//    public void setProjectList(final List<?> list) {
//        if (this.list == null) {
//            this.list = list;
//            notifyItemRangeInserted(0, list.size());
//        } else {
//            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
//                @Override
//                public int getOldListSize() {
//                    return ProjectAdapter.this.list.size();
//                }
//
//                @Override
//                public int getNewListSize() {
//                    return list.size();
//                }
//
//
//            });
//            this.list = list;
//            result.dispatchUpdatesTo(this);
//        }
//    }
//
//    @Override
//    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        ListItemBinding binding = DataBindingUtil
//                .inflate(LayoutInflater.from(parent.getContext()), R.layout.project_list_item,
//                        parent, false);
//
//        binding.setCallback(clickCallback);
//
//        return new ProjectViewHolder(binding);
//    }
//
//    @Override
//    public void onBindViewHolder(ProjectViewHolder holder, int position) {
//        holder.binding.setProject(projectList.get(position));
//        holder.binding.executePendingBindings();
//    }
//
//    @Override
//    public int getItemCount() {
//        return projectList == null ? 0 : projectList.size();
//    }
//
//    static class ProjectViewHolder extends RecyclerView.ViewHolder {
//
//        final ProjectListItemBinding binding;
//
//        public ProjectViewHolder(ProjectListItemBinding binding) {
//            super(binding.getRoot());
//            this.binding = binding;
//        }
//    }
//}
