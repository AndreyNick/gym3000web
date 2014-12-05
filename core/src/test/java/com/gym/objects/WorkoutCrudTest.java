package com.gym.objects;

import com.gym.service.ProgramService;
import com.gym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by anni0913 on 05.12.2014.
 */
public class WorkoutCrudTest extends CrudGenericTest<Workout, Long> {

    @Autowired
    WorkoutService workoutService;


    @Autowired
    private void setInsObject(Workout workout){
        setTestObject(workout);
    }


    @Override
    public Long create(Workout object) {
        return workoutService.create(object);
    }

    @Override
    public Workout read(Long id) {
        return workoutService.read(id);
    }

    @Override
    public void update(Workout object) {
        workoutService.update(object);
    }

    @Override
    public void delete(Workout object) {
        workoutService.delete(object);
    }

    @Override
    public List<Workout> readAll() {
        return workoutService.readAll();
    }
}
