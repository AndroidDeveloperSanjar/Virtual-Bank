package uz.androbeck.virtualbank.ui.screens.splash

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.androbeck.virtualbank.databinding.SplashItemBinding

class SplashAdapter() : RecyclerView.Adapter<SplashAdapter.SplashViewHolder>() {
    inner class SplashViewHolder(private val binding: SplashItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind() {
            // prosta
            binding.tv.text = (adapterPosition+1).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplashViewHolder {
        return SplashViewHolder(
            SplashItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: SplashViewHolder, position: Int) {
        holder.bind()
    }
}