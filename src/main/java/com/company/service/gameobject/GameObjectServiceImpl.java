package com.company.service.gameobject;

import com.company.database.GameObjectRepository;
import com.company.entity.gameObject.GameObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GameObjectServiceImpl implements GameObjectService{
    
    public GameObjectRepository gameObjectRepository;

    @Override
    public List<GameObject> findAllGameObjects() {
        return gameObjectRepository.getAllGameObjects();
    }

    @Override
    public List<GameObject> findGameObjectsFromPost(int postId) {
        return gameObjectRepository.getGameObjectsFromPost(postId);
    }

    @Override
    public List<GameObject> findGameObjectsOfGame(int gameId) {
        return gameObjectRepository.getGameObjectsOfGame(gameId);
    }

    @Override
    public GameObject findGameObject(int objectId) {
        return gameObjectRepository.getGameObject(objectId);
    }

    @Override
    public void addGameObject(GameObject gameObject) {
        gameObjectRepository.addGameObject(gameObject);
    }

    @Override
    public void addGameObjectToPost(int gameObjectId, int postId) {
        gameObjectRepository.addGameObjectToPost(gameObjectId, postId);
    }

    @Override
    public void removeGameObjectFromPost(int gameObjectId, int postId) {
        gameObjectRepository.deleteGameObjectFromPost(gameObjectId, postId);
    }

}
