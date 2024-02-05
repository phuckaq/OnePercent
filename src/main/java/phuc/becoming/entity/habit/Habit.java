package phuc.becoming.entity.habit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "Habit")
@Table(name = "habit")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "habit_name",
            length = 50,
            nullable = false)
    private String habitName;

    @Column(name = "icon")
    private String icon;

    @Column(name = "start_date",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDate startDate;

    @Column(name = "last_end_date")
    private LocalDate lastEndDate;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @Enumerated(EnumType.STRING)
    private HabitConsistent habitConsistent;

    @Column(name = "current_streak")
    private Integer currentStreak;

    @Column(name = "longest_streak")
    private Integer longestStreak;
}
