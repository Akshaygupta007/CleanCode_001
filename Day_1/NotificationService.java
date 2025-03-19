public class NotificationService{


    private final Map<String, notificationChannel> notificationChannels;

    public NotificationService(Map<String, notificationChannel> notificationChannels) {
        this.notificationChannels = notificationChannels;
    }

    public void sendNotification(String notificationChannel, String message) {
        NotificationChannel channel = notificationChannels.get(notificationChannel.toLowerCase());
        channel.sendNotification(message);
    }

}
public interface NotificationChannel{

    public void sendNotification(String message);
}
public class EmailNotificationChannel implements NotificationChannel{

    public void sendNotification(String message){
        print("sending email notification")
    }

}
public class SmsNotificationChannel implements NotificationChannel{

    public void sendNotification(String message){
        print("sending SMS notification")
    }
}
public class PushNotificationChannel implements NotificationChannel{

    public void sendNotification(String message){
        print("sending Push notification")
    }

}



public class NotificationManager {
    public static void main(String[] args) {
        Map<String, NotificationChannel> notificationChannels = new HashMap<>();
        notificationChannels.put("sms", new SmsNotificationChannel());
        notificationChannels.put("email", new EmailNotificationChannel());
        notificationChannels.put("push", new PushNotificationChannel());

        NotificationService notificationService = new NotificationService(notificationChannels);

        notificationService.sendNotification("sms","Hello via SMS!");
        notificationService.sendNotification("email","Hello via Email!");
        notificationService.sendNotification("push","Hello via Push Notification!");
    }
}
