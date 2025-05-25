import com.google.protobuf.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UtilisateurApi utilisateurApiMock;
    @Test
    public void testCreerUtilisateur() throws ServiceException {
// Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont",
                "jeandupont@email.com");
// TODO : Configuration du comportement du mock, utiliser la
//directive « when » avec sa méthode « thenReturn »
//
        doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);

// TODO : Création du service avec le mock
// ...
        UserService userService = new UserService(utilisateurApiMock);

// TODO : Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

// ...
// TODO : Vérification de l'appel à l'API
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
        verifyNoMoreInteractions(utilisateurApiMock);
// ...

    }

    @Test
    public void testCreerUtilisateur_exception() throws ServiceException {
        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);
        UserService userService = new UserService(utilisateurApiMock);
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jean@email.com");

        // TODO : Configuration du comportement du mock pour lever une exception
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        assertThrows(ServiceException.class, () -> {
            userService.creerUtilisateur(utilisateur);
        });

    }
    @Test
    public void testCreerUtilisateur_validationErreur_neverCalled() throws ServiceException {
        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);
        UserService userService = new UserService(utilisateurApiMock);

        Utilisateur utilisateur = null;

        // TODO : Vérification que l’API n’est jamais appelée avec un utilisateur invalide
        verify(utilisateurApiMock, never()).creerUtilisateur(any());
    }
    @Test
    public void testCreerUtilisateur_captureArguments() throws ServiceException {
        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);
        UserService userService = new UserService(utilisateurApiMock);
        Utilisateur utilisateur = new Utilisateur("Samir", "Benali", "samir@email.com");

        // TODO: Création du captor
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);

        userService.creerUtilisateur(utilisateur);

        // TODO : Capturer et vérifier les arguments
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();

        // TODO : Vérification des champs capturés
        assertEquals("Samir", utilisateurCapture.getPrenom());
        assertEquals("Benali", utilisateurCapture.getNom());
        assertEquals("samir@email.com", utilisateurCapture.getEmail());
    }
}