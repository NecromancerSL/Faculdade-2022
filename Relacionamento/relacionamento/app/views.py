from django.forms import ModelForm
from django.shortcuts import redirect, render, get_object_or_404
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
        return redirect('listar_marca')
    return render(request, template_name, {'form': form})

def listar_marca(request, template_name="marca/marca_list.html"):
    query = request.GET.get("busca")
    if query:
        marca = Marca.objects.filter(nome__iexact=query)
    else:
        marca = Marca.objects.all
    marcas = {'lista': marca}
    return render(request, template_name, marcas)


def marca_remove(request, pk, templeta_name='marca/marca_delete.html',):
    marca = Marca.objects.get(pk=pk)
    if request.method == "POST":
        marca.delete()
        return redirect("listar_marca")
    return render(request, templeta_name , {'marca': marca})


def marca_edit(request, pk, template_name='marca/marca_form.html'):
    marca = get_object_or_404(Marca, pk=pk)
    if request.method == "POST":
        form = MarcaForm(request.POST, instance=marca)
        if form.is_valid():
            form.save()
            return redirect('listar_marca')
        else:
            form = MarcaForm(instance=marca)
    return render(request, template_name, {'form': form})

def listar_produtos_marca(request, pk, template_name="marca/marca_produtos_list"):
    produtos = Produto.objects.filter(marca=pk)
    return render(request, template_name, {'produtos': produtos})

def cadastrar_produto(request, template_name="produto/produto_form.html"):
    form = ProdutoForm(request.POST or None)
    if form.is_valid():
        form.save()
        return redirect('listar_produto')
    return render(request, template_name, {'form': form})

def listar_produto(request, template_name="produto/produto_list.html"):
    query = request.GET.get("busca")
    if query:
        produto = Produto.objects.filter(nome__iexact=query)
    else:
        produto = Produto.objects.all
    produtos = {'lista': produto}
    return render(request, template_name, produtos)
