package enumerator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ConstantValues {

    VECTOR_SIZE(200),
    RANDOM_SIZE(250);

    private final int value;
}
