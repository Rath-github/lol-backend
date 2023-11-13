import { Component, OnInit } from '@angular/core';
import { jsPDF } from 'jspdf';
import { DadosService } from './dados.service';

interface Receita {
  data: string;
  valor: number;
}

@Component({
  selector: 'app-relatorio-receitas',
  templateUrl: './relatorio-receitas.component.html',
  styleUrls: ['./relatorio-receitas.component.css']
})
export class RelatorioReceitasComponent implements OnInit {
  receitas: Receita[] = [];
  logo: string = '/assets/img/logo.png';

  constructor(private dadosService: DadosService) {}

  ngOnInit(): void {
    this.dadosService.getDados().subscribe(
      (dados) => {
        this.receitas = dados.receitas || [];
      },
      (error) => {
        console.error('Erro ao carregar dados:', error);
      }
    );
  }

  gerarRelatorio(): void {
    const doc = new jsPDF();

    doc.addImage(this.logo, 'PNG', 10, 0, 50, 50);

    doc.setFont('Georgia');
    doc.setFontSize(26);
    doc.text('Relatório de Receitas', 80, 25);

    const dataAtual = new Date();
    const dataFormatada = dataAtual.toLocaleDateString('pt-BR', { year: 'numeric', month: 'long', day: 'numeric' });

    doc.setFontSize(12);
    doc.text(`Data: ${dataFormatada}`, 93, 31);

    let y = 70; 

    doc.setFontSize(13);
    for (const receita of this.receitas) {
      if (y > 250) {
        doc.addPage(); 
        y = 20; 
      }

      doc.text(`Data: ${receita.data}`, 10, y);
      doc.text(`Valor: R$ ${receita.valor.toFixed(2)}`, 60, y);

      y += 15; 
    }

    doc.save('relatorio_receitas.pdf');
  }
}