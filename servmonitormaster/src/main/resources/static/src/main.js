import {LitElement, html} from '@polymer/lit-element';

class RadChart extends LitElement {

  static get properties() {
    return {
      name: {type: String},
      usage: {type: Number},
      chart: {},
      ctx: {},
      w: {type: Number},
      h: {type: Number}
    };
  }


  constructor() {
    super();
   
  }

  updated(changedProperties) {
      
    console.log("a: "+changedProperties); // logs previous values
    console.log("b: " +this.usage); // logs current value
    if(this.usage!==undefined&&this.chart!==undefined){
    
            this.chart.data.datasets[0].data.push(this.usage);
            this.chart.data.labels.push(this.usage.toFixed(1).toString()+"%");
            this.chart.update();
            // var ro = new ResizeObserver( entries => {
            //     for (let entry of entries) { 
            //       const cr = entry.contentRect; 
            //       console.log('Element:', entry.target); 
            //       console.log(`Element size: ${cr.width}px x ${cr.height}px`); 
            //       console.log(`Element padding: ${cr.top}px ; ${cr.left}px`); 
            //     } 
            //   }); 
            //   ro.observe(this.shadowRoot.querySelector('.container'));
              // Observe one or multiple elements 
              
        
    
    }
    // if(this.usage!==undefined&&this.chart!==undefined){
        
    //     setTimeout(()=>{
    //         this.chart.data.datasets[0].data.push(this.usage);
    //         this.chart.data.labels.push(this.usage.toString());
    //     },1000)
    
    // }
  }

connectedCallback(){
   
    setTimeout(()=>{

this.ctx = this.shadowRoot.getElementById('radchart').getContext('2d');
    this.chart = new Chart(this.ctx, {
        type: 'line',
        data: {
            labels: [],
            datasets: [{
                label: this.name,
                data: [],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)'
                  
                ],
                borderColor: [
                    'rgba(255,99,132,1)'
                
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero:true
                    }
                }]
            }
        }
    });
    },200);
    
}
  

  render() {

    console.log("renderig");
    

    return html`<style> 
  :host{
    display: inline-block; /* by default, custom elements are display: inline */
  
    
    margin: 0;
  }

   
    div.container{
        
        max-width: ${this.w}px;
        max-height: ${this.h}px;
        
    }
     </style>
      <div class="container"> ${this.name} : ${this.usage.toFixed(1)}%</div>
      <div class="container">
      <canvas id="radchart" width="${this.w}" height="${this.h}"></canvas></div>`;


  }

}

customElements.define('rad-chart', RadChart);
