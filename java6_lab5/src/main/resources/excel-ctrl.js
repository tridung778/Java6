let app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope, $http) {

    $scope.import = function (files) {
        let reader = new FileReader()
        reader.onload = async () => {
            let workbook = new ExcelJS.Workbook();
            await workbook.xlsx.load(reader.result);
            const sheet = workbook.getWorksheet("Sheet1");
            sheet.eachRow((row, index) => {
                if (index > 1) {
                    let student = {
                        email: row.getCell(1).text,
                        fullName: row.getCell(2).value,
                        marks: +row.getCell(3).value,
                        gender: row.getCell(4).value,
                        country: row.getCell(5).value
                    }
                    const url = 'http://localhost:8080/rest/students'
                    $http.post(url, student).then(function (response) {
                        console.log(response.data)
                    })
                }
            })
        }
        reader.readAsArrayBuffer(files[0])
    }
})