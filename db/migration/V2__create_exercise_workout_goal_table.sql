CREATE SEQUENCE one.exercise_id_seq START 1;
CREATE TABLE one.exercise (
                              id INTEGER PRIMARY KEY DEFAULT nextval('one.exercise_id_seq'),
                              exercise_type exercise_type NOT NULL,
                              sets INTEGER NOT NULL,
                              reps INTEGER NOT NULL,
                              done BOOLEAN DEFAULT FALSE
);

CREATE SEQUENCE one.habit_id_seq START 1;
CREATE TABLE one.habit (
                           id INTEGER PRIMARY KEY DEFAULT nextval('one.habit_id_seq'),
                           habit_type habit_type NOT NULL,
                           start_date DATE NOT NULL,
                           achieved BOOLEAN NOT NULL,
                           completed_days INTEGER NOT NULL,
                           total_completed_days INTEGER NOT NULL
);

CREATE SEQUENCE one.workout_id_seq START 1;
CREATE TABLE one.workout (
                             id INTEGER PRIMARY KEY DEFAULT nextval('one.workout_id_seq'),
                             date DATE NOT NULL,
                             exercise_id INTEGER NOT NULL,
                             habit_id INTEGER NOT NULL,
                             CONSTRAINT fk_exercise FOREIGN KEY (exercise_id) REFERENCES one.exercise(id),
                             CONSTRAINT fk_habit FOREIGN KEY (habit_id) REFERENCES one.habit(id)
);

