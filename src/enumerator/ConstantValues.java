package enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstantValues {

    VECTOR_SIZE(50),
    RANDOM_SIZE(100);

    private final int value;
}
