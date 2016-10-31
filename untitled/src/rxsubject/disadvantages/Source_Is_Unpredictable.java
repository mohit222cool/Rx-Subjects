package rxsubject.disadvantages;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class Source_Is_Unpredictable {

    public static void main(String[] args) {
        Observable<String> coldObservable = Observable.create(subscriber -> {
            String[] values = new String[]{"One","Two","Three"};
            for(String s : values)
            {
                subscriber.onNext(s);
            }
        });

        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.subscribe(subscriber1);
        coldObservable.subscribe(publishSubject);

        publishSubject.onNext("I can also emit.");

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
