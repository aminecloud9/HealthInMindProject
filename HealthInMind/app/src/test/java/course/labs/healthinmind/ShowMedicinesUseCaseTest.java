package course.labs.healthinmind;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import course.labs.healthinmind.common.Form;
import course.labs.healthinmind.medecine.data.abstractions.MedicineRepository;
import course.labs.healthinmind.medecine.domain.showmedicineslist.GeneralMedicineDetails;
import course.labs.healthinmind.medecine.domain.showmedicineslist.ShowMedicinesUseCase;
import course.labs.healthinmind.screens.medicineslist.medicineslist.GeneralDisplayMedicineDetails;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShowMedicinesUseCaseTest {

    private ShowMedicinesUseCase showMedicinesUseCase;
    @Mock
    MedicineRepository medicineRepository;
    @Mock
    ShowMedicinesUseCase.ShowMedicinesUseCaseOutputPort outputPort;
    @Captor
    ArgumentCaptor<ArrayList<GeneralMedicineDetails>> ac;

    @Before
    public void setUp(){
        showMedicinesUseCase = new ShowMedicinesUseCase(medicineRepository);
        showMedicinesUseCase.registerOutputPort(outputPort);
    }

    @Test
    public void showMedicines_emptyList_handleNoMedicinesShouldBeCalled(){
        // Arrange
        when(medicineRepository.getGeneralMedicinesDetailsList()).thenReturn(new ArrayList<>());
        //Act
        showMedicinesUseCase.showMedicines();
        //Assert
        verify(outputPort).handleNoMedicines();
    }

    @Test
    public void showMedicines_notEmptyList_showMedicinesListOnOutputPort(){
        //Arrange
        ArrayList<GeneralMedicineDetails> medicines = new ArrayList<GeneralMedicineDetails>(){
            {
                add(new GeneralMedicineDetails(1,"name1",10, Form.TABLET,1));
                add(new GeneralMedicineDetails(2,"name2",10, Form.TABLET,1));

            }
        };
        when(medicineRepository.getGeneralMedicinesDetailsList()).thenReturn(medicines);

        //Act
        showMedicinesUseCase.showMedicines();

        // Assert
        verify(outputPort).showMedicinesList(ac.capture());
        assertThat(ac.getValue(),is(medicines));
    }
}
