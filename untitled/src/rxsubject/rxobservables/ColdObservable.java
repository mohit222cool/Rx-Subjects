package rxsubject.rxobservables;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by mohit.sharma on 10/18/16.
 */
public class ColdObservable {

    public static void main(String[] args) {

        Observable<Integer> coldObservable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i <= 2; i++) {
                    System.out.println("-------Emit " + i + " ---------------");
                    subscriber.onNext(i);
                }
            }
        });

        coldObservable.subscribe(subscriber1);
        coldObservable.subscribe(subscriber2);
    }

    private static Subscriber<Integer> subscriber1 = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("Subscriber 1 :" + integer);
        }

    };

    private static Subscriber<Integer> subscriber2 = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("Subscriber 2 :" + integer);
        }
    };

}
