<!DOCTYPE html>
<html dir="ltr" lang="en">
<!--===========inclui el archivo de la cabecera css o jquery====================-->
<jsp:include page="../includes/header.jsp" />  


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@0.4.0/dist/chartjs-plugin-datalabels.min.js"></script>

<style>
    canvas { 
      padding: 10px;
      min-height: 100px;
    }
    .title {
      color: #575757;
    }
</style>
<body onload="primeraCarga();">
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
        data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
        <!-- ========incluir menu superior======= -->
        <jsp:include page="../includes/menu-superior.jsp" /> 
        <!--  ========incluir menu lateral========== -->
        <jsp:include page="../includes/menu.jsp" />
        <!--==========contenido del sistema=====================================-->
        <div class="page-wrapper">
            <!--===========inicio de menu del historial de navegacion===========-->
            <div class="page-breadcrumb">
                <div class="row">
                    <div class="col-12 d-flex no-block align-items-center">
                        <h4 class="page-title">Inicio</h4>
                        <div class="ms-auto text-end">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Inicio</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Pagina</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!--===========fin del menu del historial de navegacion=============-->
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-md-flex align-items-center">
                                    <div>
                                        <h4 class="card-title"></h4>
                                        <h5 class="card-subtitle"></h5>
                                    </div>
                                </div>
                                <div class="row">
                                    <!-- contenido -->
                                        <div class="container pt-3">
                                            <div class="row">
                                              <div class="col-6">
                                                <h3 class="title">
                                                  Cuadro comparativo de ventas 2020 - 2021
                                                </h3>
                                                <canvas id="myBarGraph" width="400" height="300"></canvas>
                                              </div>
                                              <div class="col-6">
                                                <h3 class="title">
                                                  Cuadro de adjudicaciones
                                                </h3>
                                                <canvas id="myLeftBarGraph" width="400" height="300"></canvas>
                                              </div>
                                            </div>
                                            
                                            <div class="row pt-4">
                                                <div class="col-6">
                                                  <h3 class="title">
                                                    Cuadro de contratos vendidos - Resueltos
                                                  </h3>
                                                  <canvas id="mylineGraph" width="400" height="300"></canvas>
                                                </div>
                                                <!--<div class="col-6">
                                                <h3 class="title">
                                                  Gráfico de Radar
                                                </h3>
                                                <canvas id="myRadioGraph" width="400" height="400"></canvas>
                                              </div>-->
                                              
                                              <div class="col-6">
                                                <h3 class="title">
                                                  Cuadro de ventas mensuales
                                                </h3>
                                                <canvas id="myDonutGraph" width="400" height="300"></canvas>
                                              </div>
                                            </div>
                                            
                                            <div class="row">
                                                <!--<div class="col-6">
                                                  <h3 class="title">
                                                    Cuadro de contratos vendidos - Resueltos
                                                  </h3>
                                                  <canvas id="mylineGraph" width="400" height="350"></canvas>
                                                </div> -->
                                                <div class="col-6">
                                                <h3 class="title">
                                                  Cuadro estadistico de incidencias
                                                </h3>
                                                <canvas id="myLineGraph2" width="400" height="300"></canvas>
                                              </div>
                                              
                                            </div>  

                                            

                                            <!--<div class="row pt-4">
                                              <div class="col-6">
                                                <h3 class="title">
                                                  Gráfico Polar
                                                </h3>
                                                <canvas id="myPolarGraph" width="400" height="400"></canvas>
                                              </div>
                                              <div class="col-6">
                                                <h3 class="title">
                                                  Gráfico Circular
                                                </h3>
                                                <canvas id="myCircleGraph" width="400" height="400"></canvas>
                                              </div>
                                            </div>  -->  
                                          </div>
                                    <!-- fin de contenido-->
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ===========footer ============================================= -->
            <footer class="footer text-center">
                All Rights Reserved a  <a href="#">El clan</a>.
            </footer>
        </div>
        <!--================fin del contenido===================================-->
    </div>
    <!-- =========================footer - los script===========================-->
     <jsp:include page="../includes/footer.jsp" />  

</body>
<script>
var bar = document.getElementById("myBarGraph").getContext("2d");
var leftbar = document.getElementById("myLeftBarGraph").getContext("2d");
var line = document.getElementById("mylineGraph").getContext("2d");
var line2 = document.getElementById("myLineGraph2").getContext("2d");
//var radio = document.getElementById("myRadioGraph").getContext("2d");
var donut = document.getElementById("myDonutGraph").getContext("2d");
/*var polar = document.getElementById("myPolarGraph").getContext("2d");
var circle = document.getElementById("myCircleGraph").getContext("2d");
*/
var myLeftBarGraph = new Chart(leftbar, {
  type: "bar", //type: "bar"
  data: {
    labels: ["Mayo", "Junio"],
    datasets: [
      {
        label: "2020",
        data: [28, 48, 78, 19, 67, 27, 78, 19, 67, 27, 78, 19, 67, 27, 27,28, 48, 78, 19, 67, 27, 78, 19, 67, 27, 78, 19, 67, 27, 27, 27,28, 48, 78, 19, 67, 27, 78, 19, 67, 27, 78, 19, 67, 27, 27],
        backgroundColor:"rgba(0, 99, 132, 0.6)",
        /*backgroundColor: [
          "rgba(0, 99, 132, 0.6)",
          "rgba(30, 99, 132, 0.6)",
          "rgba(60, 99, 132, 0.6)",
          "rgba(90, 99, 132, 0.6)",
          "rgba(120, 99, 132, 0.6)",
          "rgba(150, 99, 132, 0.6)",
          "rgba(180, 99, 132, 0.6)",
          "rgba(210, 99, 132, 0.6)",
          "rgba(240, 99, 132, 0.6)"
        ],*/
        /*borderColor: [
          'rgba(0, 99, 132, 1)',
          'rgba(30, 99, 132, 1)',
          'rgba(60, 99, 132, 1)',
          'rgba(90, 99, 132, 1)',
          'rgba(120, 99, 132, 1)',
          'rgba(150, 99, 132, 1)',
          'rgba(180, 99, 132, 1)',
          'rgba(210, 99, 132, 1)',
          'rgba(240, 99, 132, 1)'
        ],*/
        borderWidth: 0
      }/*,
      {
        label: "2020",
        data: [65, 59, 90, 58, 77, 55],
        backgroundColor: "rgba(54, 162, 235, 0.5)",
        borderColor: "rgb(54, 162, 235)",
        borderWidth: 0
      }*/
    ]
  },
  options: {
    legend: { display: false },
    scales: {
      yAxes:[{
          //maxBarThickness: 50,
          ticks : {
            fontSize: 10,
            stepSize: 5,
            min: 0,
            beginAtZero: true,
          }
      }],
      xAxes: [
        {
          barPercentage: .8,
          maxBarThickness: 50,
          ticks : {
            fontSize: 10,
          }
        }
      ]
    },
    elements: {
      rectangle: {
        borderSkipped: "left"
      }
    },
    responsive: true,
    title: {
      display: true,
      text: "Gráfifico de ventas - 2020 - 2021"
    },
    plugins: {
     datalabels: {
       display: false
     }
    }
  }
});

var myBarGraph = new Chart(bar, {
  type: "bar",
  data: {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"],
    datasets: [
      {
        label: "2020",
        data: [28, 48, 78, 19, 67, 27],
        backgroundColor: "rgba(255, 99, 132, 0.5)",
        borderColor: "rgb(255, 99, 132)",
        borderWidth: 2
      },
      {
        label: "2021",
        data: [65, 59, 90, 58, 77, 55],
        backgroundColor: "rgba(54, 162, 235, 0.5)",
        borderColor: "rgb(54, 162, 235)",
        borderWidth: 2
      }
    ]
  },
  options: {
    tooltips: {
      cornerRadius: 0,
      caretSize: 0,
      xPadding: 16,
      yPadding: 10,
      backgroundColor: "rgba(0, 150, 100, 0.9)",
      titleFontStyle: "normal",
      titleMarginBottom: 15
    },
    plugins: {
     datalabels: {
       display: false
     }
    },
    scales: {
      yAxes: [
        {
          ticks: {
            beginAtZero: true
          }
        }
      ]
    },
    title: {
      display: true,
      text: "Gráfico de ventas - 2020 - 2021"
    },
    leyend: {
      display: false
    },
  }
});

var mylineGraph = new Chart(line, {
  type: "line",
  data: {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio"],
    datasets: [
      {
        label: "Resueltos",
        data: [45, 59, 68, 45, 45, 35, 41],
        fill: true,
        borderColor: "rgba(55, 130, 220, .65)",
        backgroundColor: "rgba(55, 130, 220, 0.1)",
        lineTension: 0,
        pointBorderWidth: 2,
        borderDash: [5, 5],
        pointStyle: "rectRounded"
      },
      {
        label: "Contratos nuevos",
        data: [65, 61, 80, 81, 51, 55, 56],
        fill: false,
        borderColor: "rgba(245, 35, 56, .65)",
        lineTension: 0,
        pointBorderWidth: 2,
        pointStyle: "rectRounded"
      }
    ]
  },
  options: {
    title: {
      display: true,
      text: "Gráfico de ventas - resueltos"
    },
    plugins: {
     datalabels: {
       display: false
     }
    }
  }
});

var mylineGraph2 = new Chart(line2, {
  type: "line",
  data: {
    xLabels: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul"],
    yLabels: [
      "",
      "Atendidas",
      "Vistas",
      "Aceptadas",
      "Solucionadas",
      "Archivadas"
    ],
    datasets: [
      {
        label: "Incidencias",
        data: [
          "Atendidas",
          "Vistas",
          "Atendidas",
          "Atendidas",
          "Aceptadas",
          "Solucionadas",
          "Aceptadas"
        ],
        fill: true,
        lineTension: 0.4,
        borderColor: "rgba(245, 35, 56, .65)",
        backgroundColor: "rgba(245, 35, 56, .25)"
      }
    ]
  },
  options: {
    responsive: true,
    title: {
      display: true,
      text: "Datos de incidencias y resoluciones"
    },
    scales: {
      xAxes: [
        {
          display: true,
          scaleLabel: {
            display: true,
            labelString: "Meses"
          }
        }
      ],
      yAxes: [
        {
          type: "category",
          position: "left",
          display: true,
          scaleLabel: {
            display: true,
            labelString: "Estado"
          },
          ticks: {
            reverse: true
          }
        }
      ]
    },
    plugins: {
     datalabels: {
       display: false
     }
    }
  }
});
/*
var myRadioGraph = new Chart(radio, {
  type: "radar",
  data: {
    labels: [
      "Ventas",
      "Exportaciones",
      "Nuevos Clientes",
      "Contrataciones",
      "RR.HH.",
      "Almaceneces",
      "Importaciones"
    ],
    datasets: [
      {
        label: "2018",
        data: [15, 39, 55, 35, 41, 15, 20],
        fill: true,
        backgroundColor: "rgba(54, 162, 235, 0.2)",
        borderColor: "rgb(54, 162, 235)",
        pointBackgroundColor: "rgb(54, 162, 235)",
        pointBorderColor: "#fff",
        pointHoverBackgroundColor: "#fff",
        pointHoverBorderColor: "rgb(54, 162, 235)"
      },
      {
        label: "2020",
        data: [67, 59, 90, 81, 50, 55, 40],
        fill: true,
        backgroundColor: "rgba(255, 99, 132, 0.2)",
        borderColor: "rgb(255, 99, 132)",
        pointBackgroundColor: "rgb(255, 99, 132)",
        pointBorderColor: "#fff",
        pointHoverBackgroundColor: "#fff",
        pointHoverBorderColor: "rgb(255, 99, 132)"
      }
    ]
  },
  options: { 
    elements: { 
      line: { 
        tension: 0, 
        borderWidth: 3 
      } 
    },
    plugins: {
     datalabels: {
       display: false
     }
    }
  }
});*/

var myDonutGraph = new Chart(donut, {
  //type: "pie",
  type: "doughnut",
  data: {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"],
    datasets: [
      {
        label: "Compras",
        data: [45, 48, 90, 20, 16, 24],
        fill: false,
        backgroundColor: [
          "rgba(255, 99, 132, 0.2)",
          "rgba(54, 162, 235, 0.2)",
          "rgba(255, 206, 86, 0.2)",
          "rgba(75, 192, 192, 0.2)",
          "rgba(153, 102, 255, 0.2)",
          "rgba(255, 159, 64, 0.2)"
        ],
        borderColor: [
          "rgba(255, 99, 132, 1)",
          "rgba(54, 162, 235, 1)",
          "rgba(255, 206, 86, 1)",
          "rgba(75, 192, 192, 1)",
          "rgba(153, 102, 255, 1)",
          "rgba(255, 159, 64, 1)"
        ],
        lineTension: 0.1
      }
    ]
  },
  options: {
    legend: {
      display: true,
      position: "top",
      labels: {
        boxWidth: 10,
        fontColor: "#444444"
      }
    },
    title: {
      display: true,
      text: "Gráfico de ventas - Enero a Junio"
    },
   plugins: {
     datalabels: {
       formatter: (value, ctx) => {

         let sum = 0;
         let dataArr = ctx.chart.data.datasets[0].data;
         dataArr.map(data => {
           sum += data;
         });
         let percentage = (value * 100 / sum).toFixed(2) + "%";
         return percentage;


       },
       color: '#fff',
     }
   }
  }
});
/*
var myPolarGraph = new Chart(polar, {
  type: "polarArea",
  data: {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo"],
    datasets: [
      {
        label: "Compras",
        data: [8, 16, 17, 3, 14],
        fill: false,
        backgroundColor: [
          "rgba(255, 99, 132, .5)",
          "rgba(54, 162, 235, .5)",
          "rgba(255, 206, 86, .5)",
          "rgba(75, 192, 192, .5)",
          "rgba(153, 102, 255, .5)"
        ],
        borderColor: [
          "rgba(255, 99, 132, .5)",
          "rgba(54, 162, 235, .5)",
          "rgba(255, 206, 86, .5)",
          "rgba(75, 192, 192, .5)",
          "rgba(153, 102, 255, .5)"
        ],
        lineTension: 0.1
      }
    ]
  },
  options: {
    legend: {
      display: true,
      position: "top",
      labels: {
        boxWidth: 10,
        fontColor: "#444444"
      }
    },
   plugins: {
     datalabels: {
       formatter: (value, ctx) => {

         let sum = 0;
         let dataArr = ctx.chart.data.datasets[0].data;
         dataArr.map(data => {
           sum += data;
         });
         let percentage = (value * 100 / sum).toFixed(2) + "%";
         return percentage;
       },
       color: '#fff',
     }
   }
  }
});
*/
/*
var myCircleGraph = new Chart(circle, {
  type: "pie",
  data: {
    labels: ["Enero", "Febrero", "Marzo", "Abril", "Mayo"],
    datasets: [
      {
        label: "Compras",
        data: [11, 28, 45, 20, 120],
        borderWidth: 0,
        backgroundColor: [
          "rgba(255, 99, 132, .6)",
          "rgba(54, 162, 235, .6)",
          "rgba(255, 206, 86, .6)",
          "rgba(75, 192, 192, .6)",
          "rgba(153, 102, 255, .6)"
        ],
        borderColor: [
          "rgba(255, 99, 132, .5)",
          "rgba(54, 162, 235, .5)",
          "rgba(255, 206, 86, .5)",
          "rgba(75, 192, 192, .5)",
          "rgba(153, 102, 255, .5)"
        ],
        lineTension: 0.1
      }
    ]
  },
  options: {
    legend: {
      display: true,
      position: "top",
      labels: {
        boxWidth: 10,
        fontColor: "#444444"
      }
    },
   plugins: {
     datalabels: {
       formatter: (value, ctx) => {

         let sum = 0;
         let dataArr = ctx.chart.data.datasets[0].data;
         dataArr.map(data => {
           sum += data;
         });
         let percentage = (value * 100 / sum).toFixed(2) + "%";
         return percentage;


       },
       color: '#fff',
     }
   }
  }
})*/;

</script>

</html>