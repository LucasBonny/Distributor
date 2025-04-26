/* eslint-disable @next/next/no-img-element */

import React, { useContext } from 'react';
import AppMenuitem from './AppMenuitem';
import { MenuProvider } from './context/menucontext';
import { AppMenuItem } from '@/types';
import Link from 'next/link';

const AppMenu = () => {

    const model: AppMenuItem[] = [
        {
            label: 'Menu',
            items: [
                { label: 'Página Inicial', icon: 'pi pi-fw pi-home', to: '/' },
                { label: 'Produtos', icon: 'pi pi-fw pi-shopping-bag', to: '/produtos' },
                { label: 'Fornecedores', icon: 'pi pi-fw pi-building', to: '/fornecedores' },
                { label: 'Funcionários', icon: 'pi pi-fw pi-users', to: '/funcionarios' },
                { label: 'Entregas', icon: 'pi pi-fw pi-truck', to: '/entregas' },
                { label: 'Relatórios', icon: 'pi pi-fw pi-chart-bar', to: '/relatorios' },
            ]
        }
    ];

    return (
        <MenuProvider>
            <ul className="layout-menu">
                {model.map((item, i) => {
                    return !item?.seperator ? <AppMenuitem item={item} root={true} index={i} key={item.label} /> : <li className="menu-separator"></li>;
                })}
            </ul>
            <div style={{ marginTop: 200 }}>
                <Link href="/venda" style={{ cursor: 'pointer'}}>
                    <img alt="Prime Blocks" className="w-full mt-3" src="https://static.wixstatic.com/media/7ada9b_1a8dfff43a11477089c0899d840ef6a9~mv2.png/v1/fill/w_289,h_72,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/7ada9b_1a8dfff43a11477089c0899d840ef6a9~mv2.png" />
                </Link>
            </div>
            
        </MenuProvider>
    );
};

export default AppMenu;
