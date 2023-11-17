package DTO.ThongKe;

import DTO.DateRangeDTO;

public class TongDoanhThuDTO {
    private DateRangeDTO dateRange;
    private Long totalExpense, totalIncome, totalProfit;

    public TongDoanhThuDTO() {
    }

    public TongDoanhThuDTO(DateRangeDTO dateRange, Long totalExpense, Long totalIncome, Long totalProfit) {
        this.dateRange = dateRange;
        this.totalExpense = totalExpense;
        this.totalIncome = totalIncome;
        this.totalProfit = totalProfit;
    }

    public DateRangeDTO getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRangeDTO dateRange) {
        this.dateRange = dateRange;
    }

    public Long getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Long totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Long getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Long totalProfit) {
        this.totalProfit = totalProfit;
    }
}
