package course.labs.healthinmind.common.dependencyinjection;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders.GeneralDisplayMedicineDetailsBuilder;
import course.labs.healthinmind.common.dependencyinjection.Builders.displaybuilders.GeneralDisplayMedicineDetailsBuilderIml;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineBuilder;
import course.labs.healthinmind.common.dependencyinjection.Builders.medicinebuilders.MedicineRoomImplBuilder;
import course.labs.healthinmind.medecine.domain.addmedicineusecase.AddMedicineUseCase;
import course.labs.healthinmind.medecine.domain.ShowMedicineDetailsUseCase;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicines;
import course.labs.healthinmind.medecine.domain.showtodaymedicine.GetTodayUpcomingMedicinesOutputPort;
import course.labs.healthinmind.screens.ImageFormMapper;
import course.labs.healthinmind.screens.addmedicine.AddReminderDialogController;
import course.labs.healthinmind.screens.ViewMvcFactory;
import course.labs.healthinmind.screens.addmedicine.reminders.StringQuantityMapper;
import course.labs.healthinmind.screens.commons.ScreensNavigator;


public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;

    private ImageFormMapper imageFormMapper;
    private StringQuantityMapper stringQuantityMapper;
    private ViewMvcFactory viewMvcFactory;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public ShowMedicineDetailsUseCase getShowMedicineDetailsUseCase(){
        return new ShowMedicineDetailsUseCase(mCompositionRoot.getMedicineRepository());
    }

    public AddMedicineUseCase getAddMedicineUseCase(AddMedicineUseCase.AddMedicineUseCaseOutputPort outputPort){
        return new AddMedicineUseCase(
                mCompositionRoot.getMedicineRepository(),
                mCompositionRoot.getRemindersRepository(),
                outputPort, mCompositionRoot.getRemindMedicinesRepository()
                );
    }

    public ViewMvcFactory getViewMvcFactory() {

        if(viewMvcFactory == null){
            viewMvcFactory = new ViewMvcFactory(getLayoutInflater());
        }
        return viewMvcFactory;
    }

    private FragmentActivity getActivity() {
        return mActivity;
    }

    private Context getContext() {
        return mActivity;
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }


    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }


    public ScreensNavigator getScreensNavigator(){
        return new ScreensNavigator(getContext());
    }

    private StringQuantityMapper getStringQuantityMapper(){

        if(stringQuantityMapper == null){
            stringQuantityMapper = new StringQuantityMapper(getContext());
        }
        return stringQuantityMapper;
    }

    public AddReminderDialogController getAddReminderDialogController(){
        return new AddReminderDialogController(getStringQuantityMapper(), getViewMvcFactory());
    }

    public MedicineBuilder getMedicineBuilder(){
        return new MedicineRoomImplBuilder();
    }

    public GetTodayUpcomingMedicines getTodayUpcomingMedicinesUseCase(GetTodayUpcomingMedicinesOutputPort outputPort){
        return new GetTodayUpcomingMedicines(outputPort,mCompositionRoot.getRemindMedicinesRepository());
    }

    public GeneralDisplayMedicineDetailsBuilder generalDisplayMedicineDetailsBuilder(){
        return new GeneralDisplayMedicineDetailsBuilderIml(getImageFormMapper());
    }

    private ImageFormMapper getImageFormMapper() {
        if(imageFormMapper == null){
            imageFormMapper = new ImageFormMapper(getContext());
        }
        return imageFormMapper;
    }
}
