package rxsubject.variants;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.BehaviorSubject;

/**
 * Created by mohit.sharma on 10/19/16.
 */
public class BehaviourSubjectDemo {
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
        
        BehaviorSubject<Integer> behaviorSubject = BehaviorSubject.create(-1);

        behaviorSubject.subscribe(subscriber1);
        behaviorSubject.subscribe(subscriber2);

        coldObservable.subscribe(behaviorSubject);
 }

    private static Subscriber<Integer> subscriber1 = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onNext(Integer Integer) {
            System.out.println("Subscriber 1 : " + Integer);
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
        public void onNext(Integer Integer) {
            System.out.println("Subscriber 2 : " + Integer);
        }
    };
}
