package com.company.service.gameobject;

import com.company.database.DataBaseService;
import com.company.entity.gameObject.GameObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameObjectServiceImpl implements GameObjectService{

    public DataBaseService dataBaseService;

    @Override
    public List<GameObject> findAllGameObjects() {
        return dataBaseService.getAllGameObjects();
    }

    @Override
    public List<GameObject> findGameObjectsFromPost(int postId) {
        return dataBaseService.getGameObjectsFromPost(postId);
    }

    @Override
    public List<GameObject> findGameObjectsOfGame(int gameId) {
        return dataBaseService.getGameObjectsOfGame(gameId);
    }

    @Override
    public GameObject findGameObject(int objectId) {
        return dataBaseService.getGameObject(objectId);
    }

    @Override
    public void addGameObject(GameObject gameObject) {
        dataBaseService.addGameObject(gameObject);
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        dataBaseService.addGameObjectToPost(gameObjectId, postId);
    }

    @Override
    public void removeGameObjectFromPost(int gameObjectId, int postId) {
        dataBaseService.deleteGameObjectFromPost(gameObjectId, postId);
    }

}
