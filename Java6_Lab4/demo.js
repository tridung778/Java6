const url = 'https://poly-java6-f608c-default-rtdb.asia-southeast1.firebasedatabase.app/'

const app = angular.module('myApp', [])

app.controller('ctrl', function ($scope, $http) {
        $scope.form;
        $scope.students = [];

        $scope.reset = function () {
            $scope.form = {gender: true , country: 'VN'};
            $scope.key = null;
        }

        $scope.loadAll = function () {
            $http.get(url + 'students.json').then(function (response) {
                $scope.students = response.data
            })
        }

        $scope.add = function () {
            $http.post(url + 'students.json', angular.copy($scope.form)).then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.delete = function (key) {
            $http.delete(url + 'students/' + key + '.json').then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.edit = function (key) {
            $scope.form = angular.copy($scope.students[key]);
            $scope.key = key;
        }

        $scope.update = function () {
            $http.put(url + 'students/' + $scope.key + '.json', angular.copy($scope.form)).then(function (response) {
                $scope.loadAll();
                $scope.reset();
            })
        }

        $scope.loadAll();
    }
)