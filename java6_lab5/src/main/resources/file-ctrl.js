app = angular.module("myApp", []);

app.controller("myCtrl", function ($scope, $http) {
    const url = "http://localhost:8080/rest/files";

    $scope.folder = 'images'; // Replace with your actual folder name

    $scope.url = function (filename) {
        return `${url}/${$scope.folder}/${filename}`;
    }

    $scope.list = function () {
        $http.get(`${url}/${$scope.folder}`).then(function (response) {
            $scope.filenames = response.data;
        }, function (error) {
            console.error(error);
        });
    }

    $scope.upload = function (files) {
        let formData = new FormData();
        for (let i = 0; i < files.length; i++) {
            formData.append("files", files[i]);
        }
        $http.post(`${url}/${$scope.folder}`, formData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(function (response) {
            $scope.filenames.push(...response.data);
        }, function (error) {
            console.error(error);
        });
    }

    $scope.delete = function (filename) {
        $http.delete(`${url}/${$scope.folder}/${filename}`).then(function (response) {
            let i = $scope.filenames.findIndex(name => name === filename);
            $scope.filenames.splice(i, 1);
        }, function (error) {
            console.error(error);
        });
    }

    $scope.list();
});
