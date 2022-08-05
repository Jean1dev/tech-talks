package shared;

public interface FakeKafkaAdapter {

    void dispatch(Object message);
}
