package models.enumeration;

public enum DeliverStatus {
    PENDING, IN_PROGRESS, ON_DELIVER, ARRIVED;

    public static DeliverStatus deliverStatus(String txt){
        if (txt.equalsIgnoreCase(DeliverStatus.PENDING.name())) {
            return DeliverStatus.PENDING;
        } else if (txt.equalsIgnoreCase(DeliverStatus.IN_PROGRESS.name())) {
            return DeliverStatus.IN_PROGRESS;
        } else if (txt.equalsIgnoreCase(DeliverStatus.ON_DELIVER.name())) {
            return DeliverStatus.ON_DELIVER;
        } else {
            return DeliverStatus.ARRIVED;
        }
    }
}
