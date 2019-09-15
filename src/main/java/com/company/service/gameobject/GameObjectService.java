package com.company.service.gameobject;

import com.company.entity.gameObject.GameObject;

import java.util.List;

public interface GameObjectService {

    List<GameObject> findAllGameObjects();

    List<GameObject> findGameObjectsFromPost(int postId);

    List<GameObject> findGameObjectsOfGame(int gameId);

    GameObject findGameObject(int objectId);

    void addGameObject(GameObject gameObject);

    void addGameObjectToPost(int gameObjectId, int postId);

    void removeGameObjectFromPost(int gameObjectId, int postId);
}
