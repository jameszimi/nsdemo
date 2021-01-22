package stw.jamez.ns.demo.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import stw.jamez.ns.demo.R
import stw.jamez.ns.demo.data.Customer
import stw.jamez.ns.demo.databinding.AdapterDashboardItemBinding

class DashBoardAdapter(private val dashBoardCallback: DashBoardActivity.DashBoardCallback): ListAdapter<Customer, DashBoardAdapter.DashBoardViewHolder>(mDashBoardCallback) {
    companion object {
        val mDashBoardCallback = object :DiffUtil.ItemCallback<Customer>() {
            override fun areItemsTheSame(oldItem: Customer, newItem: Customer): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Customer, newItem: Customer): Boolean {
                return oldItem.name == newItem.name
            }
        }
    }

    inner class DashBoardViewHolder(private val binding: AdapterDashboardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Customer) {
            binding.apply {
                setClickListener {
                    dashBoardCallback.customerOnClick(item)
                }
                name = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder {
        return DashBoardViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_dashboard_item, parent, false))
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}