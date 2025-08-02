package leetcode.challenge.leetcode_1948;

import java.util.List;
import java.util.Map;

class Folder {
    String name;
    Map<String, Folder> subFolders;
    String serialized;

    public Folder(String name) {
        this.name = name;
        this.subFolders = new java.util.HashMap<>();
    }
}

class FileSystem {
    Folder root;

    public FileSystem() {
        this.root = new Folder("");
    }

    public void addPath(List<String> path) {
        Folder current = root;
        for (String folderName : path) {
            Folder next = new Folder(folderName);
            if (!current.subFolders.containsKey(folderName)) {
                current.subFolders.put(folderName, next);
            }
            current = current.subFolders.get(folderName);
        }
    }
}

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        FileSystem fileSystem = new FileSystem();

        for (List<String> path : paths) {
            fileSystem.addPath(path);
        }

        Map<String, Integer> folderSubFolderCount = new java.util.HashMap<>();

        constructSerializedFolders(fileSystem.root, folderSubFolderCount);

        List<List<String>> result = new java.util.ArrayList<>();
        List<String> currentPath = new java.util.ArrayList<>();
        collectUniqueFolders(fileSystem.root, folderSubFolderCount, currentPath, result);

        return result;
    }

    private void constructSerializedFolders(Folder folder, Map<String, Integer> folderSubFolderCount) {
        if (folder.subFolders.isEmpty()) {
            return;
        }

        List<String> serializedSubFolders = new java.util.ArrayList<>();

        for (Folder subFolder : folder.subFolders.values()) {
            constructSerializedFolders(subFolder, folderSubFolderCount);
            serializedSubFolders.add(subFolder.name + "[" + subFolder.serialized + "]");
        }

        serializedSubFolders.sort(String::compareTo);

        StringBuilder serializedBuilder = new StringBuilder();

        for (String serializedSubFolder : serializedSubFolders) {
            serializedBuilder.append(serializedSubFolder).append(",");
        }
        folder.serialized = serializedBuilder.toString();
        folderSubFolderCount.put(folder.serialized, folderSubFolderCount.getOrDefault(folder.serialized, 0) + 1);
    }

    private void collectUniqueFolders(
            Folder folder,
            Map<String, Integer> folderSubFolderCount,
            List<String> currentPath,
            List<List<String>> result) {

        if (folderSubFolderCount.get(folder.serialized) > 1) {
            return; // Skip folders that are not unique
        }
        if (!currentPath.isEmpty()) {
            result.add(new java.util.ArrayList<>(currentPath));
        }

        for (Folder subFolder : folder.subFolders.values()) {
            currentPath.add(subFolder.name);
            collectUniqueFolders(subFolder, folderSubFolderCount, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
