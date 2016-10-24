package rxsubject.disadvantages;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class Subscriber_Get_Data_Based_On_Subscription_Time {

    public static void main(String[] args) {
        String[] values = new String[]{"Gurgaon","Faridabad","Noida"};

        PublishSubject<String> publishSubject = PublishSubject.create();

        Observable<String> coldObservable =  Observable.from(values);

        Observable<String> flatMapObservable = coldObservable.flatMap(new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s + " IT Company");
            }
        });

        flatMapObservable.subscribe(publishSubject);
        publishSubject.subscribe(subscriber1);

    }

    private static Subscriber<String> subscriber1 = new Subscriber<String>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(String value) {
            System.out.println(value);
        }

    };
}
