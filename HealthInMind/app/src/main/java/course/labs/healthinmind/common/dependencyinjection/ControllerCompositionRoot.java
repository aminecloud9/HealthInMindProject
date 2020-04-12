package course.labs.healthinmind.common.dependencyinjection;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import course.labs.healthinmind.medecine.AddMedicineUseCase;
import course.labs.healthinmind.medecine.MedicineFactory;
import course.labs.healthinmind.medecine.MedicineFactoryRoomImpl;
import course.labs.healthinmind.medecine.ShowMedicineDetailsUseCase;
import course.labs.healthinmind.screens.ViewMvcFactory;


public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;
    private MedicineFactory medicineFactory;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public ShowMedicineDetailsUseCase getShowMedicineDetailsUseCase(){
        return new ShowMedicineDetailsUseCase(mCompositionRoot.getMedicineRepository());
    }

    public AddMedicineUseCase getAddMedicineUseCase(){
        return new AddMedicineUseCase(mCompositionRoot.getMedicineRepository());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
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

    public MedicineFactory getMedicineFactory(){
        if(medicineFactory == null){
            medicineFactory = new MedicineFactoryRoomImpl();
        }

        return medicineFactory;
    }
}
