package osp.DB.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import osp.Models.FunctionName;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FunctionNameDAO {
    public static FunctionName selectFunctionNameById(Integer idFunction){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        FunctionName functionName = new FunctionName();
        List<FunctionName> functionNameList = entityManager.createQuery("FROM Function_Names WHERE id="+idFunction).getResultList();
        for (int i =0; i<functionNameList.size();i++){
            functionName = functionNameList.get(i);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return functionName;
    }

    public static ObservableList<FunctionName> getFunctionList(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ospa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<FunctionName> functionsList = entityManager.createQuery("FROM Function_Names").getResultList();
        ObservableList<FunctionName> functionsObservableList = FXCollections.observableList(functionsList);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return functionsObservableList;
    }
}
