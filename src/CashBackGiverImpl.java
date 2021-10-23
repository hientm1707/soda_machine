public class CashBackGiverImpl implements CashbackGiver{
    @Override
    public void deliverChangeToUser(int value) {
        /* Pretend to deliver cashback to user */
        if (value == 0) {
            return;
        }
        System.out.println("Delivering change ...");
        System.out.println("Value to deliver: " + value*1000 + " VND");
        System.out.println("================CASHBACK DELIVERED SUCCESSFULLY================");
    }

    @Override
    public void deliverRefundToUser(int value) {
        System.out.println("Delivering refund ...");
        System.out.println("Value to deliver: " + value*1000 + " VND");
        System.out.println("================REFUND DELIVERED SUCCESSFULLY================");
    }

}
