package job4j.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate) {
        int countByX = 0;
        int countByY = 0;
        int countByMaDi = 0;
        int countByBaDi = 0;
        for (int index = 0; index < table.length; index++) {
            countByMaDi += (predicate.test(table[index][index]) ? 1 : 0);
            countByBaDi += (predicate.test(table[table.length - index - 1][index]) ? 1 : 0);
            if (countByMaDi == table.length || countByBaDi == table.length) {
                break;
            }
            if (predicate.test(table[index][index])) {
                countByX = 0;
                countByY = 0;
                for (int eIndex = 0; eIndex < table.length && (countByX !=-1 || countByY !=-1); eIndex++) {
                    countByX += (predicate.test(table[index][eIndex]) && countByX !=-1 ? 1 : -countByX - 1);
                    countByY += (predicate.test(table[eIndex][index]) && countByY !=-1 ? 1 : -countByY - 1);
                }
                if (countByX == table.length || countByY == table.length) {
                    break;
                }
            }
        }
        return (countByX == table.length || countByY == table.length ||
                countByMaDi == table.length || countByBaDi == table.length);
    }

    public boolean isWinnerX() {
        return this.fillBy(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(Figure3T::hasNoMark);
    }
}
