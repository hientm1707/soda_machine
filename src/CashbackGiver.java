public interface CashbackGiver {
    void deliverChangeToUser(int value);
    void deliverRefundToUser(int value);
}
