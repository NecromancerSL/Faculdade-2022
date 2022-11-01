from django.forms import ModelForm
from django.shortcuts import redirect, render
from .models import *

class MarcaForm(ModelForm):
    class Meta:
        model = Marca
        fields = ['nome']

class ProdutoForm(ModelForm):
    class Meta:
        model = Produto
        fields = ['descricao', 'preco', 'marca']

def cadastrar_marca(request, template_name="marca/marca_form.html"):
    form = MarcaForm(request.POST or None)
    if form.is_valid():
        form.save()
        return redirect('marca/marca_list')
    return render(request, template_name, {'form': form})

def listar_marca(request, template_name="marca/marca_list.html"):
    query = request.GET.get("busca")
    if query:
        marca = Marca.objects.filter(nome__iexact=query)
    else:
        marca = Marca.objects.all
    marcas = {'lista': marca}
    return render(request, template_name, marcas)

